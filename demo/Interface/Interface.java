public class Interface {
    public static void main(String[] args) {

        Computer C = new Computer();
        Camera cam = new Camera();
        Phone pho = new Phone();
        
        C.useUsb(cam);
        C.useUsb(pho);
    }
}

interface Usb {
    int a = 1;
    public void start();
    public void stop();
}


interface KKK { }

class Camera implements Usb, KKK {
    public void start() {
        System.out.println("我是相机，我开始工作了");
    }
    public void stop() {
        System.out.println("我是相机，我停止工作了");
    }
}

class Phone implements Usb {
    public void start() {
        System.out.println("我是手机，我开始工作了");
    }
    public void stop() {
        System.out.println("我是手机，我停止工作了");
    }
}

class Computer {
    // 开始使用 Usb 接口
    public void useUsb (Usb usb) {
        usb.start();
        usb.stop(); 
    }
}

class Base { }
