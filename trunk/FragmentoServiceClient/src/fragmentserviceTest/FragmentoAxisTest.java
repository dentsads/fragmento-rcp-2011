package fragmentserviceTest;

import java.util.Calendar;
import java.util.Date;

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
			// System.out.println(retrieveArtifact(3l).getArtefact().getDescription());
			// System.out.println(retrieveArtifact(3l).getArtefactId());
			// System.out.println(browseArtifact("WSDL").getArtefactDescriptors().getArtefact().length);
			// createArtifact("WSDL", "This is a test","<echo xmlns='asdf'><a>Hi! This is a sample Request.</a></echo>");
			//System.out.println(retrieveArtifactBundle(3l).getArtefactBundle().getRelation());
			//System.out.println(retrieveArtifactHistory(3l).getArtefactDescriptors().getArtefact()[0].getArtefactId());
			checkinArtifact(191l,"WSDL","Test 3", "<echo xmlns='asdf'><a>Hi! This is a sample Request 3.</a></echo>", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}

	}

	/**
	 * This method creates a new artifact.
	 * 
	 * @param artifactType
	 *            Type of artifact e.g. WSDL, Process
	 * @param description
	 *            Description of the artifact
	 * @param payload
	 * @return createArtefactResponseMessage
	 */
	public static FragmentServiceStub.CreateArtefactResponseMessage createArtifact(
			String artifactType, String description, String payload) {
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
	 * This method retrieves an artifact bundle.
	 * 
	 * @param artifactId The artifact request Id in long format
	 * @return
	 */
	public static FragmentServiceStub.RetrieveArtefactBundleResponseMessage retrieveArtifactBundle(long artifactId) {
		try {
			FragmentServiceStub.RetrieveArtefactBundleRequestMessage req = new FragmentServiceStub.RetrieveArtefactBundleRequestMessage();
			req.setArtefactId(artifactId);
			
			return new FragmentServiceStub(serviceURI).retrieveArtefactBundle(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * This method retrieves the artifact history
	 * 
	 * @param artifactId The artifact request Id in long format
	 * @return
	 */
	public static FragmentServiceStub.RetrieveArtefactHistoryResponseMessage retrieveArtifactHistory(long artifactId) {
		try {
			FragmentServiceStub.RetrieveArtefactHistoryRequestMessage req = new FragmentServiceStub.RetrieveArtefactHistoryRequestMessage();
			req.setArtefactId(artifactId);

			return new FragmentServiceStub(serviceURI).retrieveArtefactHistory(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * This method checks out specific artifact and sets lock
	 * 
	 * @param artifactId The artifact request Id in long format
	 * @return
	 */
	public static FragmentServiceStub.CheckOutArtefactResponseMessage checkoutArtifact(long artifactId) {
		try {
			FragmentServiceStub.CheckOutArtefactRequestMessage req = new FragmentServiceStub.CheckOutArtefactRequestMessage();
			req.setArtefactId(artifactId);

			return new FragmentServiceStub(serviceURI).checkOutArtefact(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * This method checks in specific artifact 
	 * 
	 * @param artifactId The artifact request Id in long format
	 * @param artifactType
	 * @param description
	 * @param payload
	 * @param keepRelations keep Relations?
	 * @return
	 */
	public static FragmentServiceStub.CheckInArtefactResponseMessage checkinArtifact(
			long artifactId, String artifactType, String description, String payload, boolean keepRelations) {
		try {
			FragmentServiceStub.CheckInArtefactRequestMessage req = new FragmentServiceStub.CheckInArtefactRequestMessage();
			FragmentServiceStub.ArtefactType type = new FragmentServiceStub.ArtefactType();
			type.setType(artifactType);
			type.setDescription(description);
			type.setExtraElement(AXIOMUtil.stringToOM(payload));
			req.setArtefactId(artifactId);
			req.setKeepRelations(keepRelations);
			req.setArtefact(type);
			// TODO req.setLockId(200);
			
			return new FragmentServiceStub(serviceURI).checkInArtefact(req);
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
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byType(
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
	 * 
	 * @param date_from
	 * @param date_to
	 * @return
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byDate(
			Date date_from, Date date_to) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			FragmentServiceStub.Date_type0 date = new FragmentServiceStub.Date_type0();
			date.getFrom().setTime(date_from);
			date.getTo().setTime(date_to);
			type.setDate(date);
			req.setBrowseArtefactSelector(type);
			
			return new FragmentServiceStub(serviceURI).browseArtefacts(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * 
	 * @param content
	 * @return
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byContent(
			String content) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			type.setSearchContent(content);
			req.setBrowseArtefactSelector(type);
			
			return new FragmentServiceStub(serviceURI).browseArtefacts(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * 
	 * @param description
	 * @return
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byDescription(
			String description) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			type.setSearchDescription(description);
			req.setBrowseArtefactSelector(type);
			
			return new FragmentServiceStub(serviceURI).browseArtefacts(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
	
	/**
	 * 
	 * @param date_from
	 * @param date_to
	 * @param artifactType
	 * @return
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byDateType(
			Date date_from, Date date_to, String artifactType) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			FragmentServiceStub.TypeAndDate_type0 td = new FragmentServiceStub.TypeAndDate_type0();
			Calendar date = Calendar.getInstance();
			date.setTime(date_from);
			td.setFrom(date);
			date.setTime(date_to);
			td.setTo(date);
			td.setType(artifactType);
			type.setTypeAndDate(td);
			req.setBrowseArtefactSelector(type);
			
			return new FragmentServiceStub(serviceURI).browseArtefacts(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
}
