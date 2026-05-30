package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CartScreenController implements Initializable {

    private Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // map dữ liệu cho các cột
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));

        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<>("category"));

        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<>("cost"));

        // đổ dữ liệu vào bảng
        tblMedia.setItems(cart.getItemsOrdered());
    }
}