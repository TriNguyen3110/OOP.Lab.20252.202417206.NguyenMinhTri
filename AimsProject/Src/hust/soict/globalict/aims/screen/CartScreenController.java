package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;

import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;

import javafx.beans.value.ChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class CartScreenController implements Initializable {
    private Cart cart;
    private FilteredList<Media> filteredData;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotalCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredData = new FilteredList<>(cart.getItemsOrdered(), media -> true); // Display all medias at first

        tblMedia.setItems(filteredData);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
                else {
                    btnPlay.setVisible(false);
                    btnRemove.setVisible(false);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        cart.getItemsOrdered().addListener(new ListChangeListener<Media>() { // Update total cost continuously
            @Override
            public void onChanged(Change<? extends Media> change) {
                javafx.application.Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        updateTotalCost();
                    }
                });
            }
        });

        updateTotalCost();
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) { // Action for "Remove" button
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost(); // Update the total cost after removing media
        }
    }

    void showFilteredMedia(String filter) { // Action for search method by ID/Title
        filteredData.setPredicate(new Predicate<Media>() {
            @Override
            public boolean test(Media media) {
                if (filter == null || filter.isEmpty()) {
                    return true;
                }

                if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(filter);
                }

                if (radioBtnFilterTitle.isSelected()) {
                    return media.getTitle().toLowerCase().contains(filter.toLowerCase());
                }
                return true;
            }
        });
    }

    @FXML
    void btnPlayPressed(ActionEvent event) { // Action for "Play" button
        Media media = tblMedia.getSelectionModel().getSelectedItem();

        if (media instanceof Playable) {
            Playable curMedia = (Playable) media;

            try {
                curMedia.play();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Playing Media");
                alert.setHeaderText(null);
                alert.setContentText("Now playing: " + media.getTitle());
                alert.showAndWait();

            } catch (Exception e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Player Error");
                errorAlert.setHeaderText("Cannot play this media");
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

    void updateTotalCost(){ // The total cost Label
        float s = 0;

        for(Media media : cart.getItemsOrdered()){
            s += media.getCost();
        }

        lblTotalCost.setText(String.format("%.2f $", s));
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Order");
        alert.setHeaderText(null);

        alert.setContentText("Order placed successfully");

        alert.showAndWait();
        if (cart.getItemsOrdered() != null) {
            cart.getItemsOrdered().clear();
        }
        tblMedia.getSelectionModel().clearSelection();
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }
}