package com.yue.request.socket.utils;

import java.io.*;
import java.net.Socket;

/**
 * @Author YueDong Huan
 * @Date 2021/8/25
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class Clienttools {

    private Socket clisoc;
    private OutputStream outtoserver;
    private DataOutputStream out;

    private InputStream inFromServer;
    private DataInputStream in;

    /**
     * socket客户端类构造方法
     * @param ip
     * @param port
     */
    Clienttools(String ip,int port){
        try {
            //输出流区
            clisoc=new Socket(ip,port);
            outtoserver=clisoc.getOutputStream();
            out=new DataOutputStream(outtoserver);
            //输入流区
            inFromServer = clisoc.getInputStream();
            in = new DataInputStream(inFromServer);
        }catch(IOException e) {
            System.out.println("socket~client创建失败:"+e);
        }
        this.read();
    }


    /**
     * socket客户端类发送消息方法
     * @param mes
     */
    public void send(String mes) {
        try {
            out.writeUTF(mes);
        }catch(IOException e) {
            System.out.println("socket~client发送失败:"+e);
        }
    }


    /**
     * socket客户端类读取消息方法
     */
    public void read() {
        Readthread rt=new Readthread();
        rt.start();
    }


    /**
     * socket客户端读取线程类
     * @author Administrator
     *
     */
    public class Readthread extends Thread{
        public void run() {
            while(true)
            {
                try {
                    String tempstr=in.readUTF();
                    //System.out.println("socket~client收到消息:"+tempstr);
                    //Client.readit(tempstr);//调用主类读取中断方法

                }catch(IOException e) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ee) {
                        ee.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * socket客户端类关闭方法
     */
    public void close() {
        try {
            out.close();
            outtoserver.close();
            clisoc.close();
        }catch(IOException e) {
            System.out.println("socket~client关闭失败:"+e);
        }
    }


}
