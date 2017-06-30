package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lyy on 2017/6/29.
 */
public class MainProcess {
    public static void main(String[] args){
        MFD mfd1 = new MFD("lyy");
        MFD mfd2 = new MFD("lyy1");
        MFD mfd3 = new MFD("lyy2");

        ArrayList<MFD> mfds = new ArrayList<>();
        mfds.add(mfd1);
        mfds.add(mfd2);
        mfds.add(mfd3);
        ArrayList<UFD> ufds1 = new ArrayList<>();
        ArrayList<UFD> ufds2 = new ArrayList<>();
        ArrayList<UFD> ufds3 = new ArrayList<>();

        mfd1.setUfds(ufds1);
        mfd2.setUfds(ufds2);
        mfd3.setUfds(ufds3);
        ufds1.add(new UFD("test1-1",new boolean[]{true,true,true},11));
        ufds1.add(new UFD("test1-2",new boolean[]{true,true,true},12));
        ufds1.add(new UFD("test1-3",new boolean[]{true,true,true},13));

        ufds2.add(new UFD("test2-1",new boolean[]{true,true,true},21));
        ufds2.add(new UFD("test2-2",new boolean[]{true,true,true},22));
        ufds2.add(new UFD("test2-3",new boolean[]{true,true,true},23));


        ufds3.add(new UFD("test3-1",new boolean[]{true,true,true},31));
        ufds3.add(new UFD("test3-3",new boolean[]{true,true,true},33));
        ufds3.add(new UFD("test3-3",new boolean[]{true,true,true},33));

        ArrayList<AFD> afds = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String username;
        String nextCommand;
        boolean login = false;
        MFD temp =null;
        System.out.println("input username");
        username = sc.nextLine();

        for (MFD m1: mfds
             ) {
            if(m1.getUserName().equals(username)){
                System.out.println("login successful");
                login = true;
                temp=m1;
            }
        }
        String name;
        while(true){
            if(login){
                System.out.println("输出文件列表");

                temp.getUfds().forEach((ufd) -> System.out.println("filename:"+ufd.getFileName()+"\tfileProtectCode"+ufd.getProtectCode()+"\tfileLength"+ufd.getFileLength()));
                System.out.println("请输入命令");
                nextCommand = sc.nextLine();
                switch (nextCommand){
                    case "dir":
                        temp.getUfds().forEach((ufd) -> System.out.println("filename:"+ufd.getFileName()+"\tfileProtectCode"+ufd.getProtectCode()+"\tfileLength"+ufd.getFileLength()));
                        break;
                    case "create":
                        System.out.println("请输入文件名");
                        name = sc.nextLine();
                        temp.getUfds().add(new UFD(name));
                        break;
                    case "delete":
                        System.out.println("请输入待删除文件名");
                        name = sc.nextLine();
                        //temp.getUfds().add(new UFD(name));
                        for(UFD u:temp.getUfds()){
                            if(name.equals(u.getFileName())){
                                temp.getUfds().remove(u);
                                break;
                            }
                        }
                        System.out.println("删除成功");
                        break;

                    case "open":
                        System.out.println("请输入打开文件名");
                        name = sc.nextLine();
                        for(UFD u:temp.getUfds()){
                            if(name.equals(u.getFileName())){

                                afds.add(new AFD(u.getFileName(),u.getProtectCode(),u.getFileLength()));
                                System.out.println("打开成功"+"filename:"+u.getFileName()+"\tfileProtectCode"+u.getProtectCode()+"\tfileLength"+u.getFileLength());
                            }
                        }
                        System.out.println("当前的打开文件目录");
                        for(AFD u:afds){
                            System.out.println(""+"filename:"+u.getOpenFileName()+"\tfileProtectCode"+u.getOpenProtectCode()+"\tfileLength"+u.getReadAndWriteState());
                        }
                        break;
                    case "close":

                        System.out.println("请输入关闭文件名");
                        name = sc.nextLine();
                        for(AFD u:afds){
                            if(u.getOpenFileName().equals(name)){
                                afds.remove(u);
                                System.out.println("删除成功"+"filename:"+u.getOpenFileName()+"\tfileProtectCode"+u.getOpenProtectCode()+"\tfileLength"+u.getReadAndWriteState());
                                break;
                            }

                        }
                        System.out.println("当前的打开文件目录");
                        for(AFD u:afds){
                            System.out.println(""+"filename:"+u.getOpenFileName()+"\tfileProtectCode"+u.getOpenProtectCode()+"\tfileLength"+u.getReadAndWriteState());
                        }
                        break;
                    default:
                        System.exit(0);

                }
            }else{

                System.out.println("fail");
            }
        }




    }


}
