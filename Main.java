public class Main {

    public static void main(String[] args) {
        Apple apple = new Apple();
        Samsung samsung = new Samsung();
        apple.buyAndOperateCellPhone("잡th");
        System.out.println();
        samsung.buyAndOperateCellPhone("거늬");
    }



}

interface cellPhone {
    void buyAndOperateCellPhone(String name);
}

class Apple implements cellPhone {

    @Override
    public void buyAndOperateCellPhone(String name) {
        System.out.println(name + "님이 사과폰을 샀습니다.");
        System.out.println(name + "님이 사과폰을 켰습니다.");
        System.out.println("*** 폰 켜지는 중 *** ");
    }
}

class Samsung implements cellPhone {

    @Override
    public void buyAndOperateCellPhone(String name) {
        System.out.println(name + "님이 삼송폰을 샀습니다.");
        System.out.println(name + "님이 삼송폰을 켰습니다.");
        System.out.println("@@@ 폰 켜지는 중 @@@ ");

    }
}


