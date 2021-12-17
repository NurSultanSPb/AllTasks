package com.company;

    abstract class Product {
        int multiplyBy;
        public Product( int multiplyBy ) {
            this.multiplyBy = multiplyBy;
        }
    }

    class TimesTwo extends Product {
        public TimesTwo() {
            super(2);
        }
    }

    class TimesWhat extends Product {
        public TimesWhat(int multiplyBy) {
            super(multiplyBy);
        }
    }

