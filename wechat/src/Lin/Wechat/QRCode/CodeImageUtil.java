package Lin.Wechat.QRCode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.UUID;

public class CodeImageUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String createQrCode(String content, String filePath) {
		int width = 300;// 可放在参数列表中,�?般尺寸都是固定的
		int height = 300;// 可放在参数列表中,�?般尺寸都是固定的
		String format = "png";
		HashMap map = new HashMap();
		map.put(EncodeHintType.CHARACTER_SET, "utf-8");
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		map.put(EncodeHintType.MARGIN, 2);// 外边�?

		try {
			String uuid = UUID.randomUUID().toString();
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height);
			File temp = new File(filePath + uuid + ".png");
			Path file = temp.toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			return temp.getPath();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}