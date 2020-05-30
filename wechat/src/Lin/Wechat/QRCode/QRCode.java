package Lin.Wechat.QRCode;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QRCode {

	public static JFrame show(String url, String path) throws Exception {
		return showQRGUI(CodeImageUtil.createQrCode(url, path));
	}

	@SuppressWarnings("deprecation")
	public static JFrame showQRGUI(String path) {
		System.out.println("二维码已经生成 路径:" + path);
		JFrame jf = new JFrame();
		jf.setLocation(700, 200);
		jf.resize(300, 300);
		jf.add(new JLabel(new ImageIcon(path)));
		jf.setVisible(true);
		return jf;
	}
}