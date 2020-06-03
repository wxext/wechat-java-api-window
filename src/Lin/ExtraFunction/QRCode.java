package Lin.ExtraFunction;

import java.awt.Dimension;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {

	public JFrame show(String url, String path) throws Exception {
		return showQRGUI(createQrCode(url, path));
	}

	public JFrame showQRGUI(String path) {
		System.out.println("二维码已经生成 路径:" + path);
		JFrame jf = new JFrame();
		//jf.setLocation(700, 200);
		jf.setPreferredSize(new Dimension(300, 300));
		jf.pack();
	    jf.setLocationRelativeTo(null);
		jf.add(new JLabel(new ImageIcon(path)));
		jf.setVisible(true);
		return jf;
	}
	
	public String createQrCode(String content, String filePath) {
		int width = 300;
		int height = 300;
		String format = "png";
		HashMap<EncodeHintType,Object> map = new HashMap<EncodeHintType,Object>();
		map.put(EncodeHintType.CHARACTER_SET, "utf-8");
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		map.put(EncodeHintType.MARGIN, 2);

		try {
			String uuid = UUID.randomUUID().toString();
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
			File temp = new File(filePath + uuid + ".png");
			Path file = temp.toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			return temp.getPath();
		} catch (Exception e) {}
		return null;
	}
}