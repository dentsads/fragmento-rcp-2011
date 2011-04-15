package fragmentserviceTest;

import java.util.Calendar;
import java.util.Date;

import org.apache.axiom.om.impl.llom.util.AXIOMUtil;

import eu.compas_ict.www.fragmentservice.FragmentServiceCallbackHandler;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.BrowseLocksRequestMessage;
import eu.compas_ict.www.fragmentservice.FragmentServiceStub.RelationTypeSchemaType;

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
			// createArtifact("WSDL",
			// "This is a test","<echo xmlns='asdf'><a>Hi! This is a sample Request.</a></echo>");
			// System.out.println(retrieveArtifactBundle(3l).getArtefactBundle().getRelation());
			// System.out.println(retrieveArtifactHistory(3l).getArtefactDescriptors().getArtefact()[0].getArtefactId());
			//checkinArtifact(129l,"WSDL","Test 3","<echo xmlns='asdf'><a>Hi! This is a sample Request 3.</a></echo>",true);
			// System.out.println(browseLocks().getLockDescriptors().getLock()[0].getLockId());
			//createRelation("test relation", 201l, 196l,
			//		FragmentServiceStub.RelationTypeSchemaType.wsdl);
//			Calendar from = Calendar.getInstance(); 
//			Calendar to = Calendar.getInstance(); 
//			from.set(3, Calendar.APRIL, 12);
//			to.set(2011,Calendar.APRIL,15);
//			System.out.println(browseArtifact_byDate(from,to).getArtefactDescriptors().getArtefact()[0].getArtefactId());
			//System.out.println(browseArtifact_byContent("echo").getArtefactDescriptors().getArtefact().length);
			//System.out.println(browseArtifact_byDescription("trusted").getArtefactDescriptors().getArtefact()[0].getArtefactId());
			//System.out.println(retrieveArtifactLatestVersion(196).getArtefact().getDescription());
			//System.out.println(browseLocks().getLockDescriptors().getLock()[1].getLockId());
			//FragmentServiceStub.Lock_type0[] locks = new FragmentServiceStub.Lock_type0[1];
			//releaseLocks(locks);
			//createRelation("bla bla", 201, 210, RelationTypeSchemaType.modeller);
			//deleteRelation(226);
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
	 * @param artifactId
	 *            The artifact request Id in long format
	 * @return
	 */
	public static FragmentServiceStub.RetrieveArtefactBundleResponseMessage retrieveArtifactBundle(
			long artifactId) {
		try {
			FragmentServiceStub.RetrieveArtefactBundleRequestMessage req = new FragmentServiceStub.RetrieveArtefactBundleRequestMessage();
			req.setArtefactId(artifactId);

			return new FragmentServiceStub(serviceURI)
					.retrieveArtefactBundle(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * This method retrieves the artifact history
	 * 
	 * @param artifactId
	 *            The artifact request Id in long format
	 * @return
	 */
	public static FragmentServiceStub.RetrieveArtefactHistoryResponseMessage retrieveArtifactHistory(
			long artifactId) {
		try {
			FragmentServiceStub.RetrieveArtefactHistoryRequestMessage req = new FragmentServiceStub.RetrieveArtefactHistoryRequestMessage();
			req.setArtefactId(artifactId);

			return new FragmentServiceStub(serviceURI)
					.retrieveArtefactHistory(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * This method checks out specific artifact and sets lock
	 * 
	 * @param artifactId
	 *            The artifact request Id in long format
	 * @return
	 */
	public static FragmentServiceStub.CheckOutArtefactResponseMessage checkoutArtifact(
			long artifactId) {
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
	 * @param artifactId
	 *            The artifact request Id in long format
	 * @param artifactType
	 * @param description
	 * @param payload
	 * @param keepRelations
	 *            keep Relations?
	 * @return
	 */
	public static FragmentServiceStub.CheckInArtefactResponseMessage checkinArtifact(
			long artifactId, String artifactType, String description,
			String payload, boolean keepRelations) {
		try {
			FragmentServiceStub.CheckInArtefactRequestMessage req = new FragmentServiceStub.CheckInArtefactRequestMessage();
			FragmentServiceStub.ArtefactType type = new FragmentServiceStub.ArtefactType();
			type.setType(artifactType);
			type.setDescription(description);
			type.setExtraElement(AXIOMUtil.stringToOM(payload));
			req.setArtefactId(artifactId);
			req.setKeepRelations(keepRelations);
			req.setArtefact(type);
			req.setLockId(browseLocks().getLockDescriptors().getLock()[0].getLockId());

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
	 * Browse artifacts by Date
	 * 
	 * @param date_from
	 * @param date_to
	 * @return
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byDate(
			Calendar date_from, Calendar date_to) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			FragmentServiceStub.Date_type0 date = new FragmentServiceStub.Date_type0();
			date.setFrom(date_from);
			date.setTo(date_to);
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
	 * Browse artifacts by content
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
	 * Browse artifacts by description
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
	 * Browse artifacts by date and type
	 * 
	 * @param date_from
	 * @param date_to
	 * @param artifactType
	 * @return
	 */
	public static FragmentServiceStub.BrowseArtefactsResponseMessage browseArtifact_byDateType(
			Calendar date_from, Calendar date_to, String artifactType) {
		try {
			FragmentServiceStub.BrowseArtefactsRequestMessage req = new FragmentServiceStub.BrowseArtefactsRequestMessage();
			FragmentServiceStub.BrowseArtefactSelectorType type = new FragmentServiceStub.BrowseArtefactSelectorType();
			FragmentServiceStub.TypeAndDate_type0 td = new FragmentServiceStub.TypeAndDate_type0();
			td.setFrom(date_from);
			td.setTo(date_to);
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

	/**
	 * This method retrieves latest artefact version
	 * 
	 * @param artifactId
	 * @return
	 */
	public static FragmentServiceStub.RetrieveArtefactLatestVersionResponseMessage retrieveArtifactLatestVersion(
			long artifactId) {
		try {
			FragmentServiceStub.RetrieveArtefactLatestVersionRequestMessage req = new FragmentServiceStub.RetrieveArtefactLatestVersionRequestMessage();
			FragmentServiceStub.ArtefactSelectorType type = new FragmentServiceStub.ArtefactSelectorType();
			type.setArtefactId(artifactId);
			req.setArtefactSelector(type);

			return new FragmentServiceStub(serviceURI)
					.retrieveArtefactLatestVersion(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * browse locks
	 * 
	 * @return
	 */
	public static FragmentServiceStub.BrowseLocksResponseMessage browseLocks() {
		try {
			FragmentServiceStub.BrowseLocksRequestMessage req = new FragmentServiceStub.BrowseLocksRequestMessage();
			req.setRequest("");
			
			return new FragmentServiceStub(serviceURI).browseLocks(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * TODO
	 * 
	 * @param locks
	 * @return
	 */
	public static FragmentServiceStub.ReleaseLocksResponseMessage releaseLocks(
			FragmentServiceStub.Lock_type0[] locks) {
		try {
			FragmentServiceStub.ReleaseLocksRequestMessage req = new FragmentServiceStub.ReleaseLocksRequestMessage();
			FragmentServiceStub.LockDescriptorsType type = new FragmentServiceStub.LockDescriptorsType();
			type.setLock(browseLocks().getLockDescriptors().getLock());
			req.setLockDescriptors(type);
			return new FragmentServiceStub(serviceURI).releaseLocks(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * create Relation
	 * 
	 * @param description
	 * @param from
	 * @param to
	 * @param relationType
	 * @return
	 */
	public static FragmentServiceStub.CreateRelationResponseMessage createRelation(
			String description, long from, long to,
			FragmentServiceStub.RelationTypeSchemaType relationType) {
		try {
			FragmentServiceStub.CreateRelationRequestMessage req = new FragmentServiceStub.CreateRelationRequestMessage();
			FragmentServiceStub.RelationType type = new FragmentServiceStub.RelationType();
			type.setDescription(description);
			type.setFrom(from);
			type.setTo(to);
			type.setType(relationType);
			req.setRelation(type);
			return new FragmentServiceStub(serviceURI).createRelation(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * 
	 * @param relationId
	 * @return
	 */
	public static FragmentServiceStub.RetrieveRelationResponseMessage retrieveRelation(
			long relationId) {
		try {
			FragmentServiceStub.RetrieveRelationRequestMessage req = new FragmentServiceStub.RetrieveRelationRequestMessage();
			req.setRelationId(relationId);

			return new FragmentServiceStub(serviceURI).retrieveRelation(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * 
	 * @param relationType
	 * @return
	 */
	public static FragmentServiceStub.BrowseRelationsResponseMessage browseRelation_byType(
			String relationType) {
		try {
			FragmentServiceStub.BrowseRelationsRequestMessage req = new FragmentServiceStub.BrowseRelationsRequestMessage();
			FragmentServiceStub.RelationSelectorType type = new FragmentServiceStub.RelationSelectorType();
			type.setType(relationType);
			req.setSelector(type);

			return new FragmentServiceStub(serviceURI).browseRelations(req);
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
	public static FragmentServiceStub.BrowseRelationsResponseMessage browseRelation_byDate(
			Date date_from, Date date_to) {
		try {
			FragmentServiceStub.BrowseRelationsRequestMessage req = new FragmentServiceStub.BrowseRelationsRequestMessage();
			FragmentServiceStub.RelationSelectorType type = new FragmentServiceStub.RelationSelectorType();
			FragmentServiceStub.Interval_type0 interval = new FragmentServiceStub.Interval_type0();
			Calendar date = Calendar.getInstance();
			date.setTime(date_from);
			interval.setFromDate(date);
			date.setTime(date_to);
			interval.setToDate(date);
			type.setInterval(interval);
			req.setSelector(type);

			return new FragmentServiceStub(serviceURI).browseRelations(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * 
	 * @param sourceId
	 * @return
	 */
	public static FragmentServiceStub.BrowseRelationsResponseMessage browseRelation_bySourceId(
			long sourceId) {
		try {
			FragmentServiceStub.BrowseRelationsRequestMessage req = new FragmentServiceStub.BrowseRelationsRequestMessage();
			FragmentServiceStub.RelationSelectorType type = new FragmentServiceStub.RelationSelectorType();
			type.setFrom(sourceId);
			req.setSelector(type);

			return new FragmentServiceStub(serviceURI).browseRelations(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * 
	 * @param targetId
	 * @return
	 */
	public static FragmentServiceStub.BrowseRelationsResponseMessage browseRelation_byTargetId(
			long targetId) {
		try {
			FragmentServiceStub.BrowseRelationsRequestMessage req = new FragmentServiceStub.BrowseRelationsRequestMessage();
			FragmentServiceStub.RelationSelectorType type = new FragmentServiceStub.RelationSelectorType();
			type.setTo(targetId);
			req.setSelector(type);

			return new FragmentServiceStub(serviceURI).browseRelations(req);
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
	 * @param relationType
	 * @return
	 */
	public static FragmentServiceStub.BrowseRelationsResponseMessage browseRelation_byDateType(
			Date date_from, Date date_to, String relationType) {
		try {
			FragmentServiceStub.BrowseRelationsRequestMessage req = new FragmentServiceStub.BrowseRelationsRequestMessage();
			FragmentServiceStub.RelationSelectorType type = new FragmentServiceStub.RelationSelectorType();
			FragmentServiceStub.TypedInterval_type0 typeint = new FragmentServiceStub.TypedInterval_type0();
			Calendar date = Calendar.getInstance();
			date.setTime(date_from);
			typeint.setFromDate(date);
			date.setTime(date_to);
			typeint.setToDate(date);
			typeint.setType(relationType);
			type.setTypedInterval(typeint);
			req.setSelector(type);

			return new FragmentServiceStub(serviceURI).browseRelations(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * 
	 * @param relationId
	 * @param description
	 * @param from
	 * @param to
	 * @param relationType
	 * @return
	 */
	public static FragmentServiceStub.UpdateRelationResponseMessage updateRelation(
			long relationId, String description, long from, long to,
			RelationTypeSchemaType relationType) {
		try {
			FragmentServiceStub.UpdateRelationRequestMessage req = new FragmentServiceStub.UpdateRelationRequestMessage();
			FragmentServiceStub.RelationUpdateInformationType type = new FragmentServiceStub.RelationUpdateInformationType();
			FragmentServiceStub.Relation_type1 rel = new FragmentServiceStub.Relation_type1();
			rel.setDescription(description);
			rel.setFrom(from);
			rel.setTo(to);
			rel.setType(relationType);
			type.setRelationIdentifier(relationId);
			type.setRelation(rel);
			req.setRelationUpdate(type);

			return new FragmentServiceStub(serviceURI).updateRelation(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}

	/**
	 * 
	 * @param relationId
	 * @return
	 */
	public static FragmentServiceStub.DeleteRelationResponseMessage deleteRelation(
			long relationId) {
		try {
			FragmentServiceStub.DeleteRelationRequestMessage req = new FragmentServiceStub.DeleteRelationRequestMessage();
			req.setRelationId(relationId);

			return new FragmentServiceStub(serviceURI).deleteRelation(req);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("\n\n\n");
		}
		return null;
	}
}
