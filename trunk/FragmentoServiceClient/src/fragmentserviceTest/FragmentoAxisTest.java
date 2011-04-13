package fragmentserviceTest;

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

			//System.out.println(retrieveArtefact(3l).getArtefact().getDescription());
			// System.out.println(retrieveArtefact(3l).getArtefactId());
			System.out.println(browseArtefacts("WSDL").getArtefactDescriptors().getArtefact().length);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}

	}

	/**
	 * 
	 * This method retrieves an artefact via its artefactId and returns a
	 * RetrieveArtefact response message.
	 * 
	 * @param artefactId
	 *            The artefact request Id in long format
	 * @return Returns a RetrieveArtefactRepsonseMessage or null if exception is
	 *         caught
	 */
	public static FragmentServiceStub.RetrieveArtefactResponseMessage retrieveArtefact(
			long artefactId) {
		try {
			FragmentServiceStub.RetrieveArtefactRequestMessage req = new FragmentServiceStub.RetrieveArtefactRequestMessage();
			FragmentServiceStub.ArtefactSelectorType type = new FragmentServiceStub.ArtefactSelectorType();
			type.setArtefactId(artefactId);
			req.setArtefactSelector(type);

			return new FragmentServiceStub(serviceURI).retrieveArtefact(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * This method retrieves all artefacts of a specific type
	 * 
	 * @param artefactType
	 *            Type of artefact e.g. WSDL, Process
	 * @return Returns the corresponding broseArtefactsResponse
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtefacts(
			String artefactType) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			type.setType(artefactType);
			req.setBrowseArtefactSelector(type);

			return new FragmentServiceStub(serviceURI).browseArtefacts(req);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

}
