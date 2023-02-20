package InnerClass;

public class JavaHouse {
    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    /** static 키워드를 사용하지 않을 수 있지만 사용하는게 메모리 누수 방지 및 직렬화에 유리 */
    private static class LivingRoom {
        private double area;
        public LivingRoom(double area) {
            this.area = area;
        }
    }

}
