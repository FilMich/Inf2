package sk.uniza.fri;

import com.badlogic.gdx.math.Vector2;
import sk.uniza.fri.ENTITYTYPE;

public class Hero extends Entity{

    public Hero(Vector2 pos){
        type = ENTITYTYPE.HERO;
        width = 8;
        height = 8;
        this.pos.x = pos.x;
        this.pos.y = pos.y;
        this.pos3.x = pos.x;
        this.pos3.y = pos.y;
        texture = Media.hero;
        speed = 1;
    }

    public void update(Control control) {
        dir_x=0;
        dir_y=0;

        if(control.down)  dir_y = -1 ;
        if(control.up)    dir_y = 1 ;
        if(control.left)  dir_x = -1;
        if(control.right) dir_x = 1;

        pos.x += dir_x * speed;
        pos.y += dir_y * speed;

        pos3.x = pos.x;
        pos3.y = pos.y;
    }

    public float get_camera_x() {
        return pos.x + width/2;
    }

    public float get_camera_y() {
        return pos.y + height/2;
    }

}
