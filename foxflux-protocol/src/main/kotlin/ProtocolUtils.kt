
import io.netty.buffer.ByteBuf
import java.nio.charset.StandardCharsets

object ProtocolUtils {

    fun readVarInt(buf: ByteBuf): Int {
        var value = 0
        var bitOffset = 0
        var currentByte: Byte

        do {
            if (bitOffset == 35) {
                throw RuntimeException("VarInt is too big")
            }

            currentByte = buf.readByte()
            value = value or ((currentByte.toInt() and 0x7F) shl bitOffset)

            bitOffset += 7
        } while ((currentByte.toInt() and 0x80) != 0)

        return value
    }

    fun writeVarInt(buf: ByteBuf, value: Int) {
        var value = value
        while (true) {
            if ((value and 0x7F.inv()) == 0) {
                buf.writeByte(value)
                return
            }
            buf.writeByte((value and 0x7F) or 0x80)
            value = value ushr 7
        }
    }

    fun readString(buf: ByteBuf): String {
        val length = readVarInt(buf)
        val bytes = ByteArray(length)
        buf.readBytes(bytes)
        return String(bytes, StandardCharsets.UTF_8)
    }

    fun writeString(buf: ByteBuf, value: String) {
        val bytes = value.toByteArray(StandardCharsets.UTF_8)
        writeVarInt(buf, bytes.size)
        buf.writeBytes(bytes)
    }

    fun readUnsignedShort(buf: ByteBuf): Int {
        return buf.readUnsignedShort()
    }
}