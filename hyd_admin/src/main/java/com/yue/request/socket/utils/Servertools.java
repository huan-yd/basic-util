package com.yue.request.socket.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author YueDong Huan
 * @Date 2021/8/25
 * @Email huanyued@163.com
 * @Version 1.0
 */
public class Servertools {

    private ServerSocket sersoc;
    public Socket clisoc[]=new Socket[20];

    private DataOutputStream out;
    private InputStream inFromClient;
    private DataInputStream in;

    /**
     * 服务端类构造方法
     * @param port
     */
    Servertools(int port){
        try {
            sersoc=new ServerSocket(port);
            clisoc[0]=sersoc.accept();
            inFromClient = clisoc[0].getInputStream();
            in = new DataInputStream(inFromClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.read();//开启读取线程
    }

    /**
     * socket服务端类发送消息方法
     * @param mes
     * @param clientsoc
     */
    public void send(String mes,Socket clientsoc) {

        try {
            out = new DataOutputStream(clientsoc.getOutputStream());
            out.writeUTF(mes);

        }catch(IOException e) {
            System.out.println("socket~server发送失败:"+e);
        }
    }


    /**
     * socket服务端类读取消息方法
     */
    public void read() {
        Readthread rt=new Readthread();
        rt.start();
    }


    /**
     * socket服务端读取线程类
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
                    //Server.readit(tempstr);//调用主类读取中断方法

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
     * socket服务端类关闭方法
     */
    public void close() {
        try {
            out.close();
            clisoc[0].close();
        }catch(IOException e) {
            System.out.println("socket~server关闭失败:"+e);
        }
    }


}
