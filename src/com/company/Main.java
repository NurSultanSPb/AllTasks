package com.company;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
       ComplexNumber o1 = new ComplexNumber(2.4, 2.5);
       ComplexNumber o2 = new ComplexNumber(2.5, 2.4);
       ComplexNumber o3 = o1;
       System.out.println(o1.equals(o2));
       System.out.println(o1.hashCode() == o2.hashCode());
       System.out.println(o1.hashCode() == o3.hashCode());
       System.out.println(Double.compare(o1.im, o2.im));
       //System.out.println(o1.getClass() == o2.getClass());
    }

    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public int hashCode() {
            int result = 31;
            result = result * Double.hashCode(getRe());
            result = result + Double.hashCode(getIm());
            return result;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null) {
                return false;
            }
            if (getClass() != o.getClass()) {
                return false;
            }
            /*if (!(o instanceof ComplexNumber)) {
                return false;
            }*/
            ComplexNumber object = (ComplexNumber) o;
            //if (re != object.re) {
            //    return false;
            //}
            return (Double.compare(re, object.re) == 0 && Double.compare(im, object.im) == 0);
            //if (im != object.im) {
            //    return false;
            //}
            //return (Double.compare(im, object.im) == 0);
            //return true;
        }
    }
}
