package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ModeleConcret implements Modele {
    private static String [][] map;//游戏操作的地图
    private static String [][] map2;//游戏操作的地图

    private static String direction = "bottom";//玩家朝向  默认向下
    private int x=3;//玩家当前在数组中的坐标
    private int y=4;//玩家当前在数组中的坐标

    static {
        map = new String [][]{
                {"#","#","#","#","#","#","#","#","#","#"},
                {"#",".","$"," "," ","#",".","$"," ","#"},
                {"#"," "," "," "," ","#","#","#"," ","#"},
                {"#","#","#"," ","@"," "," "," "," ","#"},
                {"#"," "," "," "," "," ","#","#","#","#"},
                {"#",".","$"," "," "," "," ","$",".","#"},
                {"#","#","#","#","#","#","#","#","#","#"}
        };
        map2 = new String [][]{
                {"#","#","#","#","#","#","#","#","#","#"},
                {"#",".","$"," "," ","#",".","$"," ","#"},
                {"#"," "," "," "," ","#","#","#"," ","#"},
                {"#","#","#"," ","@"," "," "," "," ","#"},
                {"#"," "," "," "," "," ","#","#","#","#"},
                {"#",".","$"," "," "," "," ","$",".","#"},
                {"#","#","#","#","#","#","#","#","#","#"}
        };
    }



    public String[][] getEtat() {
        return map;
    }



    public void move(KeyCode code) {

                switch (code) {
                    case UP:
                        direction = "top";
                        //通道和目标点
                        if (map[x - 1][y] == " " || map[x - 1][y] == ".") {
                            //1.将玩家当前位置还原
                            if (map2[x][y] == ".") {
                                map[x][y] = ".";
                            } else {
                                map[x][y] = " ";
                            }
                            //3.将玩家移动过去
                            map[x - 1][y] = "@";
                            //4.记录玩家的当前坐标
                            x -= 1;

                        }
                        //如果是箱子
                        if (map[x - 1][y] == "$") {
                            //继续判断箱子的上边
                            //如果是通道或目标点
                            if (map[x - 1 - 1][y] == " " || map[x - 1 - 1][y] == ".") {
                                //移动玩家
                                if (map2[x][y] == ".") {
                                    map[x][y] = ".";
                                } else {
                                    map[x][y] = " ";
                                }
                                //3.将玩家移动过去
                                map[x - 1][y] = "@";
                                //4.记录玩家的当前坐标
                                x -= 1;
                                //移动箱子
                                //1.将箱子当前的位子不需要还原
                                //3.移动箱子
                                map[x - 1 - 1][y] ="$";

                            }
                        }
                        break;
                    case DOWN:
                        direction = "bottom";
                        //通道和目标点
                        if (map[x + 1][y] == " " || map[x + 1][y] == ".") {
                            if (map2[x][y] == ".") {
                                map[x][y] = ".";
                            } else {
                                map[x][y] = " ";
                            }
                            //3.将玩家移动过去
                            map[x + 1][y] = "@";
                            //4.记录玩家的当前坐标
                            x += 1;

                        }
                        //如果是箱子
                        if (map[x + 1][y] == "$") {
                            //继续判断箱子的上边
                            //如果是通道或目标点
                            if (map[x + 1 + 1][y] == " " || map[x + 1 + 1][y] == ".") {
                                //移动玩家
                                if (map2[x][y] == ".") {
                                    map[x][y] = ".";
                                } else {
                                    map[x][y] = " ";
                                }
                                //3.将玩家移动过去
                                map[x + 1][y] = "@";
                                //4.记录玩家的当前坐标
                                x += 1;
                                //移动箱子
                                //1.将箱子当前的位子不需要还原
                                //3.移动箱子
                                map[x + 1 + 1][y] = "$";

                            }
                        }
                        break;
                    case LEFT:
                        direction = "left";
                        //通道和目标点
                        if (map[x][y - 1] == " " || map[x][y - 1] == ".") {
                            if (map2[x][y] == ".") {
                                map[x][y] = ".";
                            } else {
                                map[x][y] = " ";
                            }
                            //3.将玩家移动过去
                            map[x][y - 1] = "@";
                            //4.记录玩家的当前坐标
                            y -= 1;
                            break;
                        }
                        //如果是箱子
                        if (map[x][y - 1] == "$") {
                            //继续判断箱子的上边
                            //如果是通道或目标点
                            if (map[x][y - 1 - 1] == " " || map[x][y - 1 - 1] == ".") {
                                //移动玩家
                                if (map2[x][y] == ".") {
                                    map[x][y] = ".";
                                } else {
                                    map[x][y] = " ";
                                }
                                //3.将玩家移动过去
                                map[x][y - 1] = "@";
                                //移动箱子
                                //1.将箱子当前的位子不需要还原
                                //3.移动箱子
                                map[x][y - 1 - 1] = "$";
                                //4.记录玩家的当前坐标
                                y -= 1;
                                //重画

                            }
                        }
                        break;
                    case RIGHT:
                        direction = "right";
                        //通道和目标点
                        if (map[x][y + 1] == " " || map[x][y + 1] == ".") {
                            if (map2[x][y] == ".") {
                                map[x][y] = ".";
                            } else {
                                map[x][y] = " ";
                            }
                            //3.将玩家移动过去
                            map[x][y + 1] = "@";
                            //4.记录玩家的当前坐标
                            y += 1;

                            break;
                        }
                        //如果是箱子
                        if (map[x][y + 1] == "$") {
                            //继续判断箱子的上边
                            //如果是通道或目标点
                            if (map[x][y + 1 + 1] == " " || map[x][y + 1 + 1] == ".") {
                                //移动玩家
                                if (map2[x][y] == ".") {
                                    map[x][y] = ".";
                                } else {
                                    map[x][y] = " ";
                                }
                                   //3.将玩家移动过去
                                map[x][y + 1] = "@";

                                //移动箱子
                                //1.将箱子当前的位子不需要还原
                                //3.移动箱子
                                map[x][y + 1 + 1] = "$";
                                //4.记录玩家的当前坐标
                                y += 1;

                            }
                        }
                        break;
                    default:
                        break;
                }
            }



    @Override
    public void reset() {
        map = new String [][]{
                {"#","#","#","#","#","#","#","#","#","#"},
                {"#",".","$"," "," ","#",".","$"," ","#"},
                {"#"," "," "," "," ","#","#","#"," ","#"},
                {"#","#","#"," ","@"," "," "," "," ","#"},
                {"#"," "," "," "," "," ","#","#","#","#"},
                {"#",".","$"," "," "," "," ","$",".","#"},
                {"#","#","#","#","#","#","#","#","#","#"}
        };
        x=3;
        y=4;
    }

    public String getDirection() {
        return direction;
    }

}
