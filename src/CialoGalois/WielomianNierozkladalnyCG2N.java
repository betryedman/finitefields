
package CialoGalois;

import Interfejsy.WielomianNierozkladalny;

/**
 *
 * @author Grzegorz
 */
public class WielomianNierozkladalnyCG2N implements WielomianNierozkladalny {
    private final long [] wielomianyNierozkladalne = new long[]{0x3l, 0x7l, 0xbl, 0x13l, 0x25l, 
    0x43l, 0x83l, 0x11dl, 0x211l, 0x409l, 0x805l, 0x1053l, 0x201bl, 0x402bl, 0x8003l, 0x1002dl, 
    0x20009l, 0x40027l, 0x80027l, 0x100009l, 0x200005l, 0x400003l, 0x800021l, 0x100001bl, 0x2000009l, 
    0x4000047l, 0x8000027l, 0x10000009l, 0x20000005l, 0x40000053l, 0x80000009l, 0x1000000afl, 0x200000053l, 
    0x40000001bl,0x800000005l, 0x100000003fl, 0x200000003fl, 0x4000000063l, 0x8000000011l, 0x10000000039l,
    0x20000000009l, 0x40000000027l, 0x80000000059l ,0x100000000021l, 0x20000000001bl, 0x400000000003l,
    0x800000000021l,0x100000000002dl, 0x2000000000071l, 0x400000000001dl, 0x800000000004bl, 0x10000000000009l,
    0x20000000000047l, 0x4000000000007dl, 0x80000000000047l, 0x100000000000095l, 0x200000000000011l, 0x400000000000063l,
    0x80000000000007bl, 0x1000000000000003l, 0x2000000000000027l, 0x4000000000000069l, 0x8000000000000003l};
    
    private long wielomianNierozkladalnyDlaN;
    
    public WielomianNierozkladalnyCG2N(int wymiarCiala2N) {
        this.wielomianNierozkladalnyDlaN = wielomianyNierozkladalne[wymiarCiala2N - 1];
    }
    
    @Override
    public long getWielomianNierozkladalny() {
        return wielomianNierozkladalnyDlaN;
    }

    @Override
    public void setWielomianNierozkladalny(int wymiarCiala2N) {
        this.wielomianNierozkladalnyDlaN = wielomianyNierozkladalne[wymiarCiala2N - 1];
    }
    
}
