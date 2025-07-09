package cat.urv.deim.models;

public class Node<A, B> {
    private A a;
    private B b;
    private Node<A, B> anteriorX, seguentX;
    private Node<B, A> anteriorY, seguentY;

    public Node(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    public Node<A, B> getAnteriorX() {
        return anteriorX;
    }

    public void setAnteriorX(Node<A, B> anteriorX) { this.anteriorX = anteriorX; }

    public Node<A, B> getSeguentX() {
        return seguentX;
    }

    public void setSeguentX(Node<A, B> seguentX) {
        this.seguentX = seguentX;
    }

    public void setAnteriorY(Node<B, A> anteriorY) {
        this.anteriorY = anteriorY;
    }

    public Node<B, A> getSeguentY() {
        return seguentY;
    }

    public void setSeguentY(Node<B, A> seguentY) {
        this.seguentY = seguentY;
    }
}

