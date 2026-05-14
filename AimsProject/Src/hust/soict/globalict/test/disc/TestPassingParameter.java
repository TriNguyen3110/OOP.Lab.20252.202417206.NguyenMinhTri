import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {

        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", "Animation", "Disney", 120, 19.95f);
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", "Animation", "Disney", 90, 24.95f);
        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle, "Unknown", "Unknown", 0, 0.0f);
    }
}