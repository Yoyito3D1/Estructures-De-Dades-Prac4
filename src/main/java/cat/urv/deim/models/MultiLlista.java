package cat.urv.deim.models;

import cat.urv.deim.exceptions.ElementNoTrobat;
import cat.urv.deim.exceptions.ElementRepetit;
import java.util.*;

public class MultiLlista<A extends Comparable<A>, B extends Comparable<B>> implements IMultiLlistaGenerica<A,B> {
    private final HashMapIndirecte<A, LlistaNode4Camins<A, B>> conjuntA;
    private final HashMapIndirecte<B, LlistaNode4Camins<B, A>> conjuntB;

    public MultiLlista() {
        conjuntA = new HashMapIndirecte<>();
        conjuntB = new HashMapIndirecte<>();
    }

    @Override
    public void inserir(A a, B b) throws ElementRepetit {
        if (existeix(a, b)) { throw new ElementRepetit("Relacio ja creada"); }

        // Busca la existencia de la fila
        LlistaNode4Camins<A, B> fila = conjuntA.element(a);
        if (fila == null) {
            fila = new LlistaNode4Camins<>();
            conjuntA.inserir(a, fila);
        }

        // Crea nou Node amb els elements a i b
        Node<A, B> shared = new Node<>(a, b);

        // Inserim el node a la llista de la fila
        fila.inserirNodeX(shared);

        // Busquem la exsitencia de la columna
        LlistaNode4Camins<B, A> columna = conjuntB.element(b);
        if (columna == null) {
            columna = new LlistaNode4Camins<>();
            conjuntB.inserir(b, columna);
        }

        // Inserim el node a la llista de la columna
        columna.inserirNodeY((Node<B, A>) shared);
    }

    @Override
    public void esborrar(A a, B b) throws ElementNoTrobat {
        if (!existeix(a, b)) { throw new ElementNoTrobat("Relacio no existent"); }

        // Busquem fila i columnes
        LlistaNode4Camins<A, B> fila = conjuntA.element(a);
        LlistaNode4Camins<B, A> columna = conjuntB.element(b);

        // Esborrem de la llista de coordenades x
        fila.esborrarNode(b);

        // esborrem de la llista de coordenades y
        columna.esborrarNode(a);

        // Esborrar en cas que una fila sigui buida
        if (fila.esBuida()) { conjuntA.esborrar(a); }
        if (columna.esBuida()) { conjuntB.esborrar(b); }
    }

    @Override
    public List<B> fila(A a) throws ElementNoTrobat {
        if (!conjuntA.buscar(a)) { throw new ElementNoTrobat("Element " + a + " no ha sigut trobat"); }

        List<B> list = new ArrayList<>();
        LlistaNode4Camins<A, B> valors = conjuntA.element(a);
        Node<A, B> current = valors.getCapX();
        while (current != null) {
            list.add(current.getB());
            current = current.getSeguentX();
        }
        return list;
    }

    @Override
    public List<A> columna(B b) throws ElementNoTrobat {
        if (!conjuntB.buscar(b)) { throw new ElementNoTrobat("Element " + b + " no ha sigut trobat"); }

        List<A> list = new ArrayList<>();
        LlistaNode4Camins<B, A> valors = conjuntB.element(b);
        Node<B, A> current = valors.getCapY();
        while (current != null) {
            list.add((A) current.getA());
            current = (Node<B, A>) current.getSeguentY();
        }
        return list;
    }

    @Override
    public boolean existeix(A a, B b) {
        LlistaNode4Camins<A, B> fila = conjuntA.element(a);
        LlistaNode4Camins<B, A> columna = conjuntB.element(b);
        return fila != null && columna != null && fila.conteNode(b);
    }
}
