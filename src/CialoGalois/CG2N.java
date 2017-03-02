
package CialoGalois;

import Interfejsy.ArytmetykaCialaGalois;
import Wyjatki.ElementNotInFieldException;
import Wyjatki.MathIllegalArgumentException;

/**
 * Class CG2N implementuje metody dla obliczeń w Ciałach Skończonych.Instancja
 * tej klasy jest określona przez n-ty wymiar Ciała Galois. Ten n-ty wymiar służy
 * do określenia wielomianu nierozkładalnego dla Ciała Galois, a metody
 * do obliczeń w zależności od tego ciała.
 *
 * @author Grzegorz Dżaman
 */
public class CG2N implements ArytmetykaCialaGalois {
    
    private static final long[] POTEGI_BINARNE = {1L, 2L, 4L, 8L, 16L, 32L, 64L, 128L, 256L, 512L, 1024L, 2048L,
        4096L, 8192L, 16384L, 32768L, 65536L, 131072L, 262144L, 524288L, 1048576L, 2097152L, 4194304L, 8388608L,
        16777216L, 33554432L, 67108864L, 134217728L, 268435456L, 536870912L, 1073741824L, 2147483648L,
        4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L,
        549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L,
        35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L,
        2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L,
        72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L,
        2305843009213693952L, 4611686018427387904L, 9223372036854775807L};
    private WielomianNierozkladalnyCG2N wielomianNierozkladalny;
    private short rozmiarCiala;
    private int wymiar;
    /**
     * Konstruuje objekt klasy CG2N. Ten obiekt jest określony przez
     * n-ty wymiar określający wielomian nierozkładalny. Ten wielomian jest używany jako wielomian charakterystyczny
     * dla Ciała Galois, w którym chcemy wykonywać operacje.
     *
     * @param wymiar n-ty wymiar Ciała Galois.
     * jest on reprezentowany przez zmienną typu int. Określa on wielomian redukcyjny,
     * którego współczynniki są tworzone z binarnej reprezenatacji tej liczby.
     */
    
    public CG2N(int wymiar) {
        try {
            wielomianNierozkladalny = new WielomianNierozkladalnyCG2N(wymiar);
        } catch(MathIllegalArgumentException exc) {
            System.out.println("Wielomian nierozkładalny musi być liczbą dodatnią.");
        }
        this.wymiar = wymiar;
        rozmiarCiala = policzIloscBitow(wielomianNierozkladalny.getWielomianNierozkladalny());
    }
    /**
     * Zwraca n-ty wymiar Ciała Galois.
     *
     * @return n-ty wymiar.
     */
    public int getWymiar() {
        return wymiar;
    }
    
    /**
     * Ustawia n-ty wymiar Ciała Galois.
     *
     * @param wymiar n-ty wymiar Ciała Galois.
     */
    
    public void setWymiar(int wymiar) {
        this.wymiar = wymiar;
    }
    
    /**
     * Zwraca wielomian nierozkładalny Ciała Galois.
     *
     * @return wielomian nierozkladalny.
     */
    public WielomianNierozkladalnyCG2N getwielomianNierozkladalny() {
        return wielomianNierozkladalny;
    }
    
    
    /**
     * Ustawi wielomian nierozkladalny do obliczeń w Ciele Galois.
     *
     * @param wielomianNierozkladalny wielomian nierozkladalny do ustawienia.
     */
    public void setWielomianNierozkladalny(WielomianNierozkladalnyCG2N wielomianNierozkladalny) {

        if (wielomianNierozkladalny.getWielomianNierozkladalny() <= 0) {
            throw new MathIllegalArgumentException("Wielomian nierozkładalny musi być liczbą dodatnią.");
        }

        this.wielomianNierozkladalny = wielomianNierozkladalny;
        rozmiarCiala = policzIloscBitow(wielomianNierozkladalny.getWielomianNierozkladalny());
    }
    
    /**
     * Zwraca maksymalną ilość bitów, która należy do Ciała Galois.
     *
     * @return rozmiar ciała.
     */
    public short getRozmiarCiala() {
        return rozmiarCiala;
    }
    
    /**
     * Liczy ilość bitów danej wartości.
     *
     * @param wartosc wartość liczbowa
     * @return liczba określająca ilość bitów.
     */
    
    public static short policzIloscBitow(long wartosc) {

        short wynik = -1;

        while (wartosc != 0) {
            wartosc >>= 1;
            wynik++;
        }

        return wynik;
    }
    
    /**
     * Metoda ta sprawdza czy dwa elementy należą do CiałaGalois. Jeżeli nie
     * to rzucany jest wyątek z odpowiednim komunikatem 
     * @param element1 element, który może należeć Ciała Galois.
     * @param element2 element, który może należeć Ciała Galois.
     */
    private void nalezyDoCiala(long element1, long element2) {
        if((element1 >= POTEGI_BINARNE[rozmiarCiala]) || (element2 >= POTEGI_BINARNE[rozmiarCiala]) ||
                (element1 < 0) || (element2 < 0)) {
            throw new ElementNotInFieldException("Wartości dla wielomianu nierozkładalnego muszą być z przwdziału"
                    + " [0, " + (POTEGI_BINARNE[rozmiarCiala] - 1) + "].");
        }
    }
    
    /**
     * Metoda ta sprawdza czy dwa elementy należą do CiałaGalois. Jeżeli nie
     * to rzucany jest wyątek z odpowiednim komunikatem 
     * @param element element, który może należeć Ciała Galois.
     */
    
    public void nalezyDoCiala(long element) {
        if((element >= POTEGI_BINARNE[rozmiarCiala])|| (element < 0)) {
            throw new ElementNotInFieldException("Wartości dla wielomianu nierozkładalnego z przwdziału"
                    + " [0, " + (POTEGI_BINARNE[rozmiarCiala] - 1) + "].");
        }
    }
    @Override
    public long dodaj(long element1, long element2) {
        nalezyDoCiala(element1, element2);
        return element1 ^ element2;
    }

    @Override
    public long odejmij(long element1, long element2) {
        nalezyDoCiala(element1, element2);
        return element1 ^ element2;
    }
 
    @Override
    public long pomnoz(long element1, long element2) {
        nalezyDoCiala(element1, element2);

        long wynik = 0;
        long aktualnyElement2 = element2;

        while (aktualnyElement2 != 0) {
            long aktualnyWynik = element1;
            int rozmiarActualnegoElement2 = policzIloscBitow(aktualnyElement2);

            for (int x = 0; x < rozmiarActualnegoElement2; x++) {
                aktualnyWynik <<= 1;
                if (aktualnyWynik > (POTEGI_BINARNE[rozmiarCiala] -1)) {
                    aktualnyWynik ^= wielomianNierozkladalny.getWielomianNierozkladalny();
                }
            }
            aktualnyElement2 ^= POTEGI_BINARNE[policzIloscBitow(aktualnyElement2)];
            wynik ^= aktualnyWynik;
        }

        return wynik;
    }
}
