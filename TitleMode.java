import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
 
import com.nompor.gtk.GameView;
import com.nompor.gtk.draw.DrawLabel;
import com.nompor.gtk.draw.GraphicsUtil;
 
public class TitleMode extends GameView {
 
	//タイトル画面の文字列オブジェクト
	DrawLabel title;
	DrawLabel start;
	DrawLabel ranking;
	DrawLabel description;
	DrawLabel end;
 
	//フォントオブジェクトの構築
	Font titleFont = new Font(Font.MONOSPACED,Font.BOLD, 60);
	Font defaultFont = new Font(Font.MONOSPACED,Font.PLAIN, 25);
 
	int cx;
 
	//ウィンドウにこのオブジェクトが設置されたら最初に呼び出しされる
	public void start() {
 
		//ウィンドウ中心座標の取得
		cx = AppManager.getW()/2;
 
		//文字列オブジェクトを構築する
		Graphics g = getGraphics();
		title = new DrawLabel(g, "戦艦ゲーム", titleFont, cx, 100);
		start = new DrawLabel(g, "ゲーム開始", defaultFont, cx, 350);
		ranking = new DrawLabel(g, "ランキング", defaultFont, cx, 400);
		description = new DrawLabel(g, "説明書", defaultFont, cx, 450);
		end = new DrawLabel(g, "終了", defaultFont, cx, 500);
	}
 
	//描画処理
	public void draw(Graphics g) {
		drawTitle(g);
	}
 
	//タイトルの描画
	void drawTitle(Graphics g) {
		//アンチエイリアシングの有効化
		GraphicsUtil.setTextAntialiasing(g, true);
 
		//背景描画
		g.drawImage(AppManager.getBackImage(), 0, 0, null);
 
		//タイトル文字列描画
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		title.draw(g);
 
		//選択肢描画
		g.setFont(defaultFont);
		start.draw(g);
		ranking.draw(g);
		description.draw(g);
		end.draw(g);
 
	}
}