//Demonstrate Inner Classes (member, local, anonymous)

class Outer {

    class MemberInner {
        void show() {
            System.out.println("This is Member Inner Class");
        }
    }

    void display() {

        class LocalInner {
            void show() {
                System.out.println("This is Local Inner Class");
            }
        }

        LocalInner l = new LocalInner();
        l.show();
    }
}

interface Test {
    void show();
}

public class Program7 {

    public static void main(String args[]) {

        System.out.println("===== INNER CLASS DEMONSTRATION =====");

        Outer o = new Outer();
        Outer.MemberInner m = o.new MemberInner();
        m.show();

        o.display();

        Test t = () -> {
            System.out.println("This is Anonymous Inner Class");
        };

        t.show();

        System.out.println("=====================================");
    }
}