public class Merge2Array {

    long l= 10000000000L;
    Integer sum= Math.toIntExact(l % 10);
    int i=(int)l%10;

    public static void main(String[] ad){
        int a[]={1,3,6,0,0,0};
        int b[]={2,4,5};

        int j=0;
        int i=0;
        int temp=b[j];
        int temp2=0;
        while(j<b.length && i<a.length-1){

            if(temp>a[i] ){
                temp2=a[i];
                a[i]=temp;
                temp=temp2;
                temp2=0;
                i++;
            }
            if(a[i]>b[j]){
                temp=a[i];
                a[i]=b[j];
                j++;
            }
        }

        System.out.println(a);

    }

}
