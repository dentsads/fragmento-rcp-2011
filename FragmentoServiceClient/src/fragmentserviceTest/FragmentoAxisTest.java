package fragmentserviceTest;

import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub;

/**
 * 
 * @author Dimitrios Dentsas
 * @version 1.0
 */
public class FragmentoAxisTest {

	/**
	 * This String provides the corresponding service URI
	 */
	private static final String serviceURI = "http://localhost:8080/Repository/services/FragmentService";

	/**
	 * Get the serviceURI
	 * 
	 * @return
	 */
	public static String getServiceuri() {
		return serviceURI;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//System.out.println(retrieveArtifact(3l).getArtefact().getDescription());
			// System.out.println(retrieveArtifact(3l).getArtefactId());
			//System.out.println(browseArtifact("WSDL").getArtefactDescriptors().getArtefact().length);
			//createArtifact("WSDL", "This is a test", "<echo xmlns='asdf'><a>Hi! This is a sample Request.</a></echo>");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}

	}

	/**
	 * 
	 * This method retrieves an artifact via its artifactId and returns a
	 * RetrieveArtefact response message.
	 * 
	 * @param artifactId
	 *            The artifact request Id in long format
	 * @return Returns a RetrieveArtefactRepsonseMessage or null if exception is
	 *         caught
	 */
	public static FragmentServiceStub.RetrieveArtefactResponseMessage retrieveArtifact(
			long artifactId) {
		try {
			FragmentServiceStub.RetrieveArtefactRequestMessage req = new FragmentServiceStub.RetrieveArtefactRequestMessage();
			FragmentServiceStub.ArtefactSelectorType type = new FragmentServiceStub.ArtefactSelectorType();
			type.setArtefactId(artifactId);
			req.setArtefactSelector(type);

			return new FragmentServiceStub(serviceURI).retrieveArtefact(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * This method retrieves all artifacts of a specific type
	 * 
	 * @param artifactType
	 *            Type of artifact e.g. WSDL, Process
	 * @return Returns the corresponding broseArtefactsResponse
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact(
			String artifactType) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			type.setType(artifactType);
			req.setBrowseArtefactSelector(type);

			return new FragmentServiceStub(serviceURI).browseArtefacts(req);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * This method creates a new artifact.
	 * 
	 * @param artifactType Type of artifact e.g. WSDL, Process
	 * @param description Description of the artifact
	 * @param payload
	 * @return createArtefactResponseMessage
	 */
	public static FragmentServiceStub.CreateArtefactResponseMessage createArtifact(String artifactType, String description, String payload) {
		try {			
			FragmentServiceStub.CreateArtefactRequestMessage req = new FragmentServiceStub.CreateArtefactRequestMessage();			
			FragmentServiceStub.ArtefactType type = new FragmentServiceStub.ArtefactType();
			type.setType(artifactType);
			req.setArtefact(type);
			req.getArtefact().setDescription(description);
			req.getArtefact().setExtraElement(AXIOMUtil.stringToOM(payload));
			
			return new FragmentServiceStub(serviceURI).createArtefact(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
}
