package org.example;

public class House {

    private String houseName;
    private int nbEtage;
    private String typeToit;
    private boolean isPiscine;


    public House(String houseName, int nbEtage, String typeToit, boolean isPiscine) {
        this.houseName = houseName;
        this.nbEtage = nbEtage;
        this.typeToit = typeToit;
        this.isPiscine = isPiscine;
    }

    @Override
    public String toString() {
        return "House [houseName=" + houseName + ", nbEtage=" + nbEtage + ", typeToit=" + typeToit + ", isPiscine=" + isPiscine + "]";
    }

    public static HouseModernesBuilder builderModerneHouse() {
        return new HouseModernesBuilder();
    }

    public static class HouseModernesBuilder implements IHouseBuilder {
        private String houseName;
        private int nbEtage;
        private String typeToit;
        private boolean isPiscine;

        @Override
        public IHouseBuilder setHouseName(String houseName) {
            this.houseName = houseName;
            return this;
        }

        @Override
        public IHouseBuilder setEtage(int etage) {
            this.nbEtage = etage;
            return this;
        }

        @Override
        public IHouseBuilder setTypeToit(String typeToit) {
            this.typeToit = typeToit;
            return this;
        }

        @Override
        public IHouseBuilder setPiscine(boolean piscine) {
            this.isPiscine = piscine;
            return this;
        }

        @Override
        public House build() {
            return new House(houseName, nbEtage, typeToit, isPiscine);
        }
    }

    public static HouseTradiBuilder builderTradiHouse() {
        return new HouseTradiBuilder();
    }

    public static class HouseTradiBuilder implements IHouseBuilder {
        private String houseName;
        private int nbEtage;
        private String typeToit;
        private boolean isPiscine;

        @Override
        public IHouseBuilder setHouseName(String houseName) {
            this.houseName = houseName;
            return this;
        }

        @Override
        public IHouseBuilder setEtage(int etage) {
            this.nbEtage = etage;
            return this;
        }

        @Override
        public IHouseBuilder setTypeToit(String typeToit) {
            this.typeToit = typeToit;
            return this;
        }

        @Override
        public IHouseBuilder setPiscine(boolean piscine) {
            this.isPiscine = piscine;
            return this;
        }

        @Override
        public House build() {
            return new House(houseName, nbEtage, typeToit, isPiscine);
        }
    }
}
