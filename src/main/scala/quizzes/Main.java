package quizzes;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        C c = new C();
//        c.value = "a";
        B b = new B();
        b.c = c;
        A a = new A();
        a.b = b;
//        Optional.of(a.b.c.value).get();
//        Optional.of(a).map(a::b).map(c)
//        System.out.println(Optional.of(a.b.c.value));
        Optional.of(a).map(A::getB).map(B::getC).map(C::getValue).orElse(null);


    }
}

class A {
    B b;

    public B getB() {
        return b;
    }
}

class B {
    C c;

    public C getC() {
        return c;
    }
}

class C {
    String value;

    public String getValue() {
        return value;
    }
}
