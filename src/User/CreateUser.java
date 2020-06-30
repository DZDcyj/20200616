package User;

public class CreateUser {
    private int id;//账户ID
    private String weChatName;//微信名称
    private String passWord;//密码
    private int age;//年龄
    private String sex;//性别
    private String address;//地址

    public CreateUser(int id,String weChatName,String passWord,int age,String sex,String address){
        this.id=id;
        this.weChatName=weChatName;
        this.passWord=passWord;
        this.age=age;
        this.sex=sex;
        this.address=address;
    }

    //注册账户
    public User CreateUser(){
        User user=new User();
        user.setUserId(id);
        user.setUserName(weChatName);
        user.setUserAge(age);
        user.setUserSex(sex);
        user.setUserAddress(address);

        return user;
    }
}