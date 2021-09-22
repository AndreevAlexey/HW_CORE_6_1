package com.company;

public enum Group {
    WORK {
        public String toString(){
            return "Работа";
        }
    },
    FRIENDS {
        public String toString() {
            return "Друзья";
        }
    },
    HOME {
        public String toString() {
            return "Дом";
        }
    };
    @Override
    public abstract String toString();
}
