package Prepare;

import java.util.Arrays;

public class Run {
    public static void main(String[] args) {
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[]{1, 2, 3, 67, 89, 45});
        System.out.println(asciiCharSequence.toString());

    }
    public static class AsciiCharSequence implements java.lang.CharSequence{
        private byte[] bytes;
        public AsciiCharSequence(byte[] bytes) {
            this.bytes = bytes;
        }

        @Override
        public int length() {
            return bytes.length;
        }

        @Override
        public char charAt(int index) {
            return (char) bytes[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(Arrays.copyOfRange(bytes, start, end));
        }

        @Override
        public String toString() {
            return new String(bytes);
        }
    }

}
