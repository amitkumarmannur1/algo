import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class MethodCall1 {
    ClassPool cp = ClassPool.getDefault();
    CtClass ctClass = cp.get("dummy.A");

    public MethodCall1() throws NotFoundException {
    }

    public void aMethod() throws NotFoundException, CannotCompileException {

        CtMethod method = ctClass.getDeclaredMethod("b");
        getMethodCall(method);
    }

    private void getMethodCall(CtMethod method) throws CannotCompileException {
        method.instrument(
                new ExprEditor() {
                    public void edit(MethodCall m)
                            throws CannotCompileException {
                        if (!m.getClassName().contains("java.io"))
                            System.out.println(m.getClassName() + "." + m.getMethodName() + " ");
                        try {
                            if (!m.getClassName().contains("java.io")) {
                                ctClass = cp.get(m.getClassName());
                                CtMethod method = ctClass.getDeclaredMethod(m.getMethodName());
                                getMethodCall(method);
                            }

                        } catch (NotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void main(String[] args) {
        try {
            MethodCall1 methodCall1 = new MethodCall1();
            methodCall1.aMethod();
        } catch (NotFoundException | CannotCompileException e) {
            e.printStackTrace();
        }
    }
}

