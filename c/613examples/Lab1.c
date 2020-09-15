#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>

long copyLSB(long x)
{
    int leastSIgnificantBit = x & 0x01;
    return ~leastSIgnificantBit + 1;
}

long distinctNegation(long x)
{
    long y = ~x + 1;
    return !!(y ^ x);
}

long getByte(long x, long n)
{
    return (x >> 8 * n) & 0xFF;
}

long conditional(long x, long y, long z)
{
    long tmp = !x;
    long comparator = (tmp << 63) >> 63;
    return ((~comparator) & y) | (comparator & z);

    // x = ~(!!(x)) + 1;
    // return (x & y) | (~x & z); //make x either all 0 or all 1
}
long subtractionOK(long x, long y)
{
    //calculate x - y
    long z = x + (~y + 1);
    //get msb
    int msbX = (x >> 63) & 0x01;
    int msbY = (y >> 63) & 0x01;
    int msbZ = (z >> 63) & 0x01;
    //check the most significant sign
    return !((msbX ^ msbY) & (msbX ^ msbZ));
}

long isLessOrEqual(long x, long y)
{
    // 1. x = y
    // 2. x < 0 and y > 0
    // 3. x, y have same sign x - y < 0
    long z = x + (~y + 1);
    int msbZ = (z >> 63) & 0x01;
    int msbx = (x >> 63) & 0x01;
    int msbY = (y >> 63) & 0x01;
    int sameSign = ~(msbx ^ msbY);
    return !(x ^ y) | (msbx & !(msbY)) | (sameSign & msbZ);
}

long bitMask(long highbit, long lowbit)
{
    long maxbit = ~0;
    long tmp = maxbit << (highbit + 1);
    long shiftHigh = (maxbit << highbit) << 1;
    long shiftLow = maxbit << lowbit;
    printf("shiftHigh -> %x\n", shiftHigh);
    printf("shiftLow -> %x\n", shiftLow);
    return (shiftHigh ^ shiftLow) & shiftLow;
}

long trueThreeFourths(long x)
{
    //x * 3/4 = (x/4) * 3
    // = (int_part + remainder_part/4) * 3
    //= int_part * 3 + (remainder_part/4) * 3
    //remainder_part = x & 3
    // when x < 0, addNumber = 4-1 = 3 remainder + addNumber to make the result towards 0
    long intPart = x >> 2;
    long intPartThree = (intPart << 1) + intPart;
    long remainder = x & 0x03;
    long remainderPartThree = (remainder << 1) + remainder;
    long correction = (remainderPartThree + ((x >> 63) & 0x03)) >> 2;
    return intPartThree + correction;
}

int multFiveEighths(int x)
{
    int multFive = (x << 2) + x;

    // if multFive is negative, add 2^3 - 1 = 7 before right shift
    int addNum = 7 & (multFive >> 31);
    int divEight = (multFive + addNum) >> 3;

    return divEight;
}

int bitCount(int x)
{

    long hex0000FFFF = (0xFF << 8) | 0xFF;
    long hex00FF00FF = hex0000FFFF ^ (hex0000FFFF << 8);
    long hex0F0F0F0F = hex00FF00FF ^ (hex00FF00FF << 4);
    long hex33333333 = hex0F0F0F0F ^ (hex0F0F0F0F << 2);
    long hex55555555 = hex33333333 ^ (hex33333333 << 1);
    x = (x & hex55555555) + ((x >> 1) & hex55555555);
    x = (x & hex33333333) + ((x >> 2) & hex33333333);
    x = (x & hex0F0F0F0F) + ((x >> 4) & hex0F0F0F0F);
    x = (x & hex00FF00FF) + ((x >> 8) & hex00FF00FF);
    x = (x & hex0000FFFF) + ((x >> 16) & hex0000FFFF);
    return x;

    // int hex0F0F = (0x0F << 8) | 0x0F;
    // int hex0F0F0F0F = (hex0F0F << 16) | hex0F0F;
    // int hex33333333 = hex0F0F0F0F ^ (hex0F0F0F0F << 2);
    // int hex55555555 = hex33333333 ^ (hex33333333 << 1);

    // x = (x & hex55555555) + ((x >> 1) & hex55555555);
    // x = (x & hex33333333) + ((x >> 2) & hex33333333);
    // x = (x + (x >> 4)) & hex0F0F0F0F;

    // // Same concept with above but save more ops
    // x = x + (x >> 8);
    // x = (x + (x >> 16)) & 0xFF;

    // return x;
}

long bitCount1(long x)
{
    long seed = (0xFFL << 8) | 0xFFL;
    long mask1 = (seed << 16) | 0xffffL;
    printf("long size %d\n", sizeof(long));
    printf("mask1 is %ld\n", mask1);
    long mask2 = mask1 ^ (mask1 << 16);
    printf("mask2 is %x\n", mask2);
    long mask3 = mask2 ^ (mask2 << 8);
    printf("mask3 is %x\n", mask3);
    long mask4 = mask3 ^ (mask3 << 4);
    printf("mask4 is %x\n", mask4);
    long mask5 = mask4 ^ (mask4 << 2);
    printf("mask5 is %x\n", mask5);
    long mask6 = mask5 ^ (mask5 << 1);
    printf("mask6 is %x\n", mask6);
    x = (x & mask6) + ((x >> 1) & mask6);
    x = (x & mask5) + ((x >> 2) & mask5);
    x = (x & mask4) + ((x >> 4) & mask4);
    x = (x & mask3) + ((x >> 8) & mask3);
    x = (x & mask2) + ((x >> 16) & mask2);
    x = (x & mask1) + ((x >> 32) & mask1);
    return x;
}

unsigned floatNegate(unsigned uf)
{
    int mask1 = 0x7f800000;
    int mask2 = 0x007fffff;
    int isNaN = ((uf & mask1) == mask1) && ((uf & mask2) != 0);
    if (isNaN)
    {
        return uf;
    }
    uf = uf ^ (0x01 << 31);
    return uf;
}
unsigned floatNegate1(unsigned uf)
{
    int mask1 = 0x7f800000;
    int mask2 = 0x7fffffff;
    int x = mask2 & uf;
    int isNaN = ((mask1 + (~x + 1)) >> 31) & 0x01;
    if (isNaN)
    {
        return uf;
    }
    uf = uf ^ (0x01 << 31);
    return uf;
}

int isNaN(unsigned uf)
{
    int mask1 = 0x7f800000;
    int mask2 = 0x7fffffff;
    int ufx = mask2 & uf;
    int isNaN = ((mask1 + (~ufx + 1)) >> 31) & 0x01;
    return isNaN;
}

int floatIsLess(unsigned uf, unsigned ug)
{
    // both are 0 or NaN
    if (isNaN(uf) || isNaN(ug) || (!((uf | ug) << 1)))
    {
        return 0;
    }
    int signu = uf >> 31;
    int signg = ug >> 31;
    int sameSign = !(signu ^ signg);
    //1.signu = 1 and signg = 0
    //2.signu = signg
    if (signu & (!signg))
    {
        return 0x01;
    }
    if (sameSign)
    {
        int minusSign = ((uf + (~ug + 1)) >> 31) & 0x01;
        //f, g are >0 and f-g <0 or f,g <0, f-g > 0
        if ((!signu && minusSign) || ((signu && !minusSign)))
        {
            return 1;
        }
    }
    return 0;
}

int floatIsLess1(unsigned uf, unsigned ug) // 23? ops
{
    // Check if uf is NaN or ug is NaN or both are zero
    if ((uf & 0x7FFFFFFF) > 0x7F800000 || (ug & 0x7FFFFFFF) > 0x7F800000 ||
        !((uf | ug) << 1))
        return 0;
    int uf_sign = uf >> 31;
    int ug_sign = ug >> 31;
    // (uf is neg and ug is pos || (both are neg && uf < ug) ||
    // (both are pos && uf > ug))
    if (uf_sign > ug_sign ||
        (ug_sign == uf_sign && ((ug_sign && ug < uf) || (!ug_sign && uf < ug))))
        return 1;
    return 0;
}

unsigned floatScale4(unsigned uf)
{
    int mask1 = 0x7f800000;
    int mask2 = 0x7fffffff;
    //get sign part
    int sign = uf & 0x80000000L;
    printf("sign is %x\n", sign);
    int x = mask2 & uf;
    int isNaNf = ((mask1 + (~x + 1)) >> 31) & 0x01;
    if (isNaNf)
    {
        return uf;
    }
    for (int i = 0; i < 2; i++)
    {
        //get the exponent part
        int exp = uf & mask1;
        printf("exp is %x\n", exp);
        // if the exponent part is zero, left shift uf directly
        if (!(exp ^ mask1))
        {
            return uf;
        }
        if (!exp)
        {
            uf = sign | (uf << 1);
        }
        //otherwise expoent part plus 2. 4 * f =(-1)^sM2^k * 4 = (-1)^sM2^(k+2)
        else
        {
            uf = uf + 0x800000L;
            exp = uf & mask1;
            if (!(exp ^ mask1))
            {
                uf = uf & 0xff800000;
            }
        }
    }
    return uf;
}

unsigned floatScale64(unsigned uf) // 15? ops
{
    int sign = uf & 0x80000000;
    int num_loop = 2;
    while (num_loop--)
    {
        int exponent = uf & 0x7F800000;
        int exponent_is_zero = !exponent;
        if (exponent_is_zero)
        {
            uf = sign | (uf << 1);
        }
        else if (exponent != 0x7F800000)
        {
            uf = uf + 0x800000;
            exponent = uf & 0x7F800000;
            // Check if grater than INF
            if (exponent == 0x7F800000)
            {
                uf = uf & 0xFF800000; // clear fraction
            }
        }
    }
    return uf;
}
int main()
{
    int8_t x = 0xffL;
    printf("x = %d\n", x);
    long a = copyLSB(5L);
    long ans2 = distinctNegation(-9223372036854775808L);
    long ans3 = getByte(0x12345678L, 1);
    long ans4 = conditional(0L, -9223372036854775808L, 9223372036854775807L);
    long ans41 = conditional(0L, 1L, 2L);
    long ans42 = conditional(3L, 3L, 2L);
    long ans43 = conditional(-9223372036854775808L, -9223372036854775808L, 9223372036854775807L);
    long x1 = 0x8000000000000000L;
    long y1 = 0x8000000000000000L;
    long subtraction1 = subtractionOK(x1, y1);
    long lessOrEqual = isLessOrEqual(4L, 5L);
    long lessOrEqual2 = isLessOrEqual(4L, 4L);
    long lessOrEqual1 = isLessOrEqual(5L, 4L);
    long lessOrEqual12 = isLessOrEqual(-9223372036854775808L, 9223372036854775807L);
    long lessOrEqual21 = isLessOrEqual(1L, -9223372036854775808L);

    long bitMask1 = bitMask(63L, 0L);
    long three1 = trueThreeFourths(9223372036854775807L);
    long three2 = trueThreeFourths(12L);

    long count1 = bitCount1(5L);
    long count2 = bitCount1(7L);
    long count13 = bitCount(-2L);
    long count12 = bitCount1(-2L);

    unsigned f1 = floatNegate(1L);
    unsigned f2 = floatNegate(2143289344L);
    unsigned f11 = floatNegate(-1L);
    unsigned f21 = floatNegate(2143289344L);

    int flostles1 = floatIsLess(4L, 5L);
    int flostles2 = floatIsLess(5L, 4L);
    int flostles3 = floatIsLess(0L, -0L);
    int flostles4 = floatIsLess(2147483648L, 8388608L);
    int flostles5 = floatIsLess(2147483648L, 2155872256L);
    int flostles51 = floatIsLess1(2147483648L, 2155872256L);
    int flostles53 = floatIsLess1(4L, 2155872256L);

    unsigned scale = floatScale4(2130706432L);
    unsigned scale12 = floatScale4(8388606L);
    unsigned scale13 = floatScale4(2130706431L);
    printf("%x\n", 2130706431L);

    unsigned scale11 = floatScale4(2L);
    unsigned scale1 = floatScale64(2130706432L);

    return 0;
}
