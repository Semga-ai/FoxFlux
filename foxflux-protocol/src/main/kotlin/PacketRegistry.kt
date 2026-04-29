class PacketRegistry {
    val packetList: MutableMap<PacketData,IAbstractPacket> = mutableMapOf()

    fun registryPacket(packet: IAbstractPacket, data: PacketData) {
        packetList.put(data,packet)
    }
}