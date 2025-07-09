package cat.urv.deim.models;

public class LlistaNode4Camins<V, E> {
    private Node<V, E> capX, capY, cuaX, cuaY;
    private int numNodes;

    public LlistaNode4Camins() {
        numNodes = 0;
        capX = null;
        capY = null;
        cuaX = null;
        cuaY = null;
    }

    public void inserirNodeX(Node<V, E> node) {
        if (capX == null) {
            capX = cuaX = node;
            capX.setAnteriorX(null);
        } else {
            cuaX.setSeguentX(node);
            node.setAnteriorX(cuaX);
            cuaX = node;
        }
        cuaX.setSeguentX(null);
        numNodes++;
    }

    public void inserirNodeY(Node<V, E> node) {
        if (capY == null) {
            capY = cuaY = node;
            capY.setAnteriorY(null);
        } else {
            cuaY.setSeguentY((Node<E, V>) node);
            node.setAnteriorY((Node<E, V>) cuaY);
            cuaY = node;
        }
        cuaY.setSeguentY(null);
        numNodes++;
    }

    public Node<V, E> getCapX() {
        return capX;
    }

    public Node<V, E> getCapY() {
        return capY;
    }

    public boolean conteNode(E e) {
        Node<V, E> actual = capX;
        while (actual != null) {
            if (actual.getB().equals(e)) { return true; }
            actual = actual.getSeguentX();
        }
        return false;
    }

    public void esborrarNode(E b) {
        Node<V, E> actual = capX;
        while (actual != null) {
            if (actual.getB().equals(b)) {
                Node<V, E> anteriorX = actual.getAnteriorX();
                Node<V, E> seguentX = actual.getSeguentX();
                if (anteriorX != null) {
                    anteriorX.setSeguentX(seguentX);
                } else {
                    capX = seguentX;
                }
                if (seguentX != null) {
                    seguentX.setAnteriorX(anteriorX);
                } else {
                    cuaX = anteriorX;
                }
                numNodes--;
                break;
            }
            actual = actual.getSeguentX();
        }
    }

    public boolean esBuida() {
        return numNodes == 0;
    }
}