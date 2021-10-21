public class GC {

        // to store object name
        String obj_name;

        public GC(String obj_name)
        {
            this.obj_name = obj_name;
        }

        // Driver method
        public static void main(String args[])
        {
            GC t1 = new GC("t1");
            GC t2 = new GC("t2");


            t1=null;
            t2=null;
            // calling garbage collector

            System.gc();
        }

        @Override
    /* Overriding finalize method to check which object
     is garbage collected */
        protected void finalize() throws Throwable
        {
            // will print name of object
            System.out.println();
            System.out.println(this.obj_name + " successfully garbage collected");
        }

}
