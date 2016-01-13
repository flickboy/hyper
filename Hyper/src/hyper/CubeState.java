package hyper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * State variables associated with my connection to the Cube.
 */
class CubeState
{
	// Hypercube dimension
	int dim = 0;

	// My CubeAddress
	CubeAddress addr = CubeAddress.NODE_ZERO;
	
	// The nonces I need to reply with when connecting
	ArrayList<Double> nonces = new ArrayList<>();

	// PROTOCOL TO HERE
	
	// My neighbor nodes
	ArrayList<Neighbor> neighbors = new ArrayList<>();
	
	// Next-hop routing information
	HashMap<CubeAddress, Neighbor> routeCache = new HashMap<>();
}
