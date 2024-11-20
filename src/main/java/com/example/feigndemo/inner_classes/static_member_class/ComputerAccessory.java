package com.example.feigndemo.inner_classes.static_member_class;

public class ComputerAccessory {

    private int core;
    private static int instance;

    public class Mouse {
        private static int width = 7;
        public int getCore() {
            return core;
        }

        public int getInstance() {
            return instance;
        }
    }

    public static class Monitor {
        private final int size;
        private static int width;
        public Monitor(int size) {
            this.size = size;
        }
        public String toString() {
            return "Monitor size: " + size;
        }

        public int getInstance() {
            return instance;
        }
    }

    public static class Keyboard {
        private final int keys;
        public Keyboard(int keys) {
            this.keys = keys;
        }
        public String toString() {
            return "Number of keys: " + keys;
        }
    }

    public static void main(String[] args) {
        ComputerAccessory computer = new ComputerAccessory();
        Mouse mouse = computer.new Mouse();
        Monitor monitor = new Monitor(21);
        Keyboard keyboard = new Keyboard(102);

        System.out.println("Mouse core: " + mouse.getCore());
        System.out.println("Mouse instance: " + mouse.getInstance());
        System.out.println(monitor);
        System.out.println(keyboard);
    }
}
