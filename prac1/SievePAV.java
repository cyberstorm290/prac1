import library.*;

class SievePAV {
  
  static public void main(String[] args) {
    final int Max = 32000;
    boolean[] uncrossed = new boolean[Max];
    int i, n, k, it, iterations, primes = 0;
    { IO.write("How many iterations? "); iterations = IO.readInt(); }
    boolean display = iterations == 1;
    { IO.write("Supply largest number to be tested "); n = IO.readInt(); }
    if (n > Max) {
      { IO.write("n too large, sorry"); }
      return;
    }
    { IO.write("Prime numbers between 2 and "); IO.write(n); IO.write("\n"); }
    { IO.write("-----------------------------------\n"); }
    it = 1;
    while (it <= iterations) {
      primes = 0;
      i = 2;
      while (i <= n) {
        uncrossed[i - 2] = true;
        i = i + 1;
      }
      i = 2;
      while (i <= n) {
        if (uncrossed[i - 2]) {
          if (display && ((primes - ((primes / 8) * 8)) == 0)) {
            { IO.write("\n"); }
            primes = primes + 1;
            if (display)
              { IO.write(i); IO.write("\t"); }
            k = i; {
              uncrossed[k - 2] = false;
              k = k + i;
            }
            while (k <= n);
            i = i + 1;
          }
        }
        it = it + 1;
        if (display)
          { IO.write("\n"); }
      }
      { IO.write(primes); IO.write(" primes"); }
    }
  } // main
  
} // SievePAV