package Interfaces;

import java.util.Arrays;

public class TaskOne {
    public static void main(String[] args) {
        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(0));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
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
            String result = "";
            for (byte by: bytes) {
                result += (char) by;
            }
            return result;
        }

    }
}
