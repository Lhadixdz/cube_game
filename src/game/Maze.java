package game;

import java.awt.*;

public class Maze {

    // جدران المتاهة
    private final Rectangle[] walls = {
            new Rectangle(0, 0, 500, 20),    // أعلى
            new Rectangle(0, 0, 20, 500),    // يسار
            new Rectangle(480, 0, 20, 500),  // يمين
            new Rectangle(0, 480, 500, 20),  // أسفل

            // جدران داخلية (مثال)
            new Rectangle(100, 100, 300, 20),
            new Rectangle(100, 200, 20, 200),
            new Rectangle(200, 300, 200, 20)
    };

    // رسم الجدران
    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        for (Rectangle wall : walls) {
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }
    }

    // التحقق من التصادم مع المربع
    public boolean collides(int x, int y, int size) {
        Rectangle cube = new Rectangle(x, y, size, size);
        for (Rectangle wall : walls) {
            if (cube.intersects(wall)) {
                return true;
            }
        }
        return false;
    }
}
