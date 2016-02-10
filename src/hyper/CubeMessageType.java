
package hyper;

/**
 * An enum holding different types of CubeMessages.
 */
enum CubeMessageType {
	/**
	 * Messages exchanged during Phase 1: Determining attachment point based on CubeAddress topology
	 */

	// Message (outside the Cube) from CLT to INN, requesting a CubeAddress
	// Src: INVALID_ADDRESS
	// Dest: INVALID_ADDRESS
	// Data: CLT's TCP address
	CONN_EXT_INN_ATTACH,

	// Message from INN to other Cube nodes, asking recipients for ability and willingness to accept connection
	// Src: INN
	// Dest: BCAST_FORWARD
	// Data: CLT's TCP address
	CONN_INN_GEN_ANN,

	// Message from generic Cube node to INN, declaring nodes willing and able to accept connection
	// Src: BCAST_REVERSE
	// Dest: INN
	// Data: CLT's TCP address, bitmap of unwilling nodes
	CONN_GEN_INN_AVAIL,

	// Message from INN to selected address negotiation node (ANN), tentatively handing off negotiation
	// Src: INN
	// Dest: Node that responded CONN_GEN_INN_AVAIL
	// Data: CLT's TCP address
	CONN_INN_ANN_HANDOFF,

	/**
	 * Messages exchanged during Phase 3: ANN offers a CubeAddress to the external client
	 */

	// Message (outside the Cube) from ANN to CLT, offering it a new CubeAddress
	// Src: INVALID_ADDRESS
	// Dest: offered CubeAddress
	// Data: the dimension of the Cube and the number of neighbors
	CONN_ANN_EXT_OFFER,

	// Message (outside the Cube) from CLT to ANN, accepting the offer
	// Src: accepted CubeAddress
	// Dest: INVALID_ADDRESS
	// Data: null
	CONN_EXT_ANN_ACCEPT,

	// Message (outside the Cube) from CLT to ANN, CLT is unwilling to connect through ANN; ANN must abort
	// Src: INVALID_ADDRESS
	// Dest: INVALID_ADDRESS
	// Data: null
	CONN_EXT_ANN_DECLINE,

	/**
	 * Messages exchanged during Phase 4: Neighbors connect to the external client
	 */

	// Message from ANN to NBR, instructing NBR to connect to CLT
	// Src: ANN
	// Dest: NBR
	// Data: CLT's TCP address
	CONN_ANN_NBR_CONNECT,

	// Message (outside the Cube) from NBR to CLT, offering to connect
	// Src: INVALID_ADDRESS
	// Dest: INVALID_ADDRESS
	// Data: null
	CONN_NBR_EXT_OFFER,

	// Message (outside the Cube) from CLT to NBR, accepting the connection
	// Src: CLT
	// Dest: INVALID_ADDRESS
	// Data: null
	CONN_EXT_NBR_ACCEPT,

	// Message (outside the Cube) from CLT to NBR, declining the connection
	// Src: INVALID_ADDRESS
	// Dest: INVALID_ADDRESS
	// Data: null
	CONN_EXT_NBR_DECLINE,

	// Message from NBR to ANN, indicating connection established
	// Src: NBR
	// Dest: ANN
	// Data: CLT's TCP address
	CONN_NBR_ANN_CONNECTED,

	// Message from NBR to ANN, indicating failed connection
	// Src: NBR
	// Dest: ANN
	// Data: CLT's TCP address
	CONN_NBR_ANN_DISCONNECTED,

	/**
	 * Messages exchanged during Phase 5: Each neighbor advertises its CubeAddress to the external client
	 */

	// Message from ANN to NBR, instructing NBR to advertise its Cube address to CLT
	// Src: ANN
	// Dest: NBR
	// Data: CLT's TCP address
	CONN_ANN_NBR_IDENTIFY,

	// Message (outside the Cube) from NBR to CLT, identifying NBR's Cube address
	// Src: NBR
	// Dest: CLT
	// Data: null
	CONN_NBR_EXT_IDENTIFY,

	// Message from NBR to ANN, indicating that the client was informed and state is correct
	// Src: NBR
	// Dest: CLT
	// Data: null
	CONN_NBR_ANN_IDENTIFIED,

	// Message from ANN to CLT, declaring successful address negotiation
	// Src: ANN
	// Dest: CLT
	// Data: null
	CONN_ANN_EXT_SUCCESS,

	// Message from ANN to INN, declaring successful address negotiation
	// Src: ANN
	// Dest: INN
	// Data: CLT's TCP address
	CONN_ANN_INN_SUCCESS,

	// Message from INN to unable ANNs, declaring successful address negotiation
	// Src: INN
	// Dest: ANN
	// Data: CLT's TCP address
	CONN_INN_GEN_CLEANUP,

	/**
	 * Failure messages exchanged during multiple phases
	 */

	// Invalid message format (including source/destination address)
	// Src: varies
	// Dest: varies
	// Data: message type
	INVALID_MSG,

	// Invalid (i.e., unconnected) Cube address
	// Src: the invalid address
	// Dst: the node that sent the message to the invalid address
	// Data: the original data
	INVALID_ADDRESS,

	// Invalid protocol state
	// Src: varies
	// Dest: varies
	// Data: Type[] of current state, attempted transition state
	INVALID_STATE,

	// Invalid message data
	// Src: varies
	// Dest: varies
	// Data: varies
	INVALID_DATA,

	// Message (outside the Cube) from ingress negotiation node (INN) to client (CLT), rejecting a connection
	// Src: INVALID_ADDRESS
	// Dest: INVALID_ADDRESS
	// Data: null (could be extended to include a reason)
	CONN_INN_EXT_CONN_REFUSED,

	// Message from address negotiation node (ANN) to INN, declaring unsuccessful address negotiation
	// Src: ANN
	// Dest: INN
	// Data: CLT's TCP address
	CONN_ANN_INN_FAIL,

	// Message from ANN to new neighbor (NBR), declaring unsuccessful address negotiation
	// Src: ANN
	// Dest: NBR
	// Data: CLT's TCP address
	CONN_ANN_NBR_FAIL,

	// Message from ANN to CLT, declaring unsuccessful address negotiation
	// Src: INVALID_ADDRESS
	// Dest: INN
	// Data: CLT's TCP address
	CONN_ANN_EXT_FAIL,

	/**
	 * Messages exchanged post-connection
	 */

	// Message between Cube nodes, containing useful data
	// Data: arbitrary
	DATA_MSG,

	// Message from a Cube node, informing its neighbors that it's disconnecting
	// Data: (optional) String providing a reason
	NODE_SHUTDOWN,
}