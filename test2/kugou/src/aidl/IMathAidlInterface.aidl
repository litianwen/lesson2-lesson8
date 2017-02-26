// IMathAidlInterface.aidl
package aidl;
import aidl.User;
// Declare any non-default types here with import statements

interface IMathAidlInterface {


    int add(int i,int j);


    void login(out User user); 
}
