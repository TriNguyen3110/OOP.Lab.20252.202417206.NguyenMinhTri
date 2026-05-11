package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc {
        private int id;
        private String title;
        private String category;
        private String director;
        private int length;
        private float cost;

        private static int nbDigitalVideoDiscs = 0;

        public DigitalVideoDisc(String title){
            this.title = title;
            updateID();
        }

        public DigitalVideoDisc(String category, String title, float cost){
            this.title = title;
            this.category = category;
            this.cost = cost;
            updateID();
        }

        public DigitalVideoDisc(String director, String category, String title, float cost){
            this.director = director;
            this.category = category;
            this.title = title;
            this.cost = cost;
            updateID();
        }

        public DigitalVideoDisc(String title, String category, String director, int length, float cost){
            this.title = title;
            this.category = category;
            this.director = director;
            this.length = length;
            this.cost = cost;
            updateID();
        }

        private void updateID(){
            nbDigitalVideoDiscs ++;
            this.id = nbDigitalVideoDiscs;
        }

        public boolean isMatch(String title){
            return this.title.equalsIgnoreCase(title);
        }

        @Override
        public String toString(){
            return  id + ".DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
        }

        public int getID(){
            return id;
        }
        public String getTitle(){
            return title;
        }
        public String getCategory(){
            return category;
        }
        public String getDirector(){
            return director;
        }
        public int getLength(){
            return length;
        }
        public float getCost(){
            return cost;
        }

        public void setTitle(String title){
            this.title = title;
        }
}