
/**
 * FragmentServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:18:42 CET)
 */

    package eu.compas_ict.www.fragmentservice;

    /**
     *  FragmentServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class FragmentServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public FragmentServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public FragmentServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for browseRelations method
            * override this method for handling normal response from browseRelations operation
            */
           public void receiveResultbrowseRelations(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.BrowseRelationsResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from browseRelations operation
           */
            public void receiveErrorbrowseRelations(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkInArtefact method
            * override this method for handling normal response from checkInArtefact operation
            */
           public void receiveResultcheckInArtefact(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.CheckInArtefactResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkInArtefact operation
           */
            public void receiveErrorcheckInArtefact(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for checkOutArtefact method
            * override this method for handling normal response from checkOutArtefact operation
            */
           public void receiveResultcheckOutArtefact(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.CheckOutArtefactResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from checkOutArtefact operation
           */
            public void receiveErrorcheckOutArtefact(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveArtefactLatestVersion method
            * override this method for handling normal response from retrieveArtefactLatestVersion operation
            */
           public void receiveResultretrieveArtefactLatestVersion(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.RetrieveArtefactLatestVersionResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveArtefactLatestVersion operation
           */
            public void receiveErrorretrieveArtefactLatestVersion(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveArtefact method
            * override this method for handling normal response from retrieveArtefact operation
            */
           public void receiveResultretrieveArtefact(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.RetrieveArtefactResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveArtefact operation
           */
            public void receiveErrorretrieveArtefact(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deleteRelation method
            * override this method for handling normal response from deleteRelation operation
            */
           public void receiveResultdeleteRelation(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.DeleteRelationResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteRelation operation
           */
            public void receiveErrordeleteRelation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for browseLocks method
            * override this method for handling normal response from browseLocks operation
            */
           public void receiveResultbrowseLocks(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.BrowseLocksResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from browseLocks operation
           */
            public void receiveErrorbrowseLocks(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createRelation method
            * override this method for handling normal response from createRelation operation
            */
           public void receiveResultcreateRelation(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.CreateRelationResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createRelation operation
           */
            public void receiveErrorcreateRelation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for releaseLocks method
            * override this method for handling normal response from releaseLocks operation
            */
           public void receiveResultreleaseLocks(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.ReleaseLocksResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from releaseLocks operation
           */
            public void receiveErrorreleaseLocks(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for browseArtefacts method
            * override this method for handling normal response from browseArtefacts operation
            */
           public void receiveResultbrowseArtefacts(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.BrowseArtefactsResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from browseArtefacts operation
           */
            public void receiveErrorbrowseArtefacts(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveArtefactBundle method
            * override this method for handling normal response from retrieveArtefactBundle operation
            */
           public void receiveResultretrieveArtefactBundle(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.RetrieveArtefactBundleResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveArtefactBundle operation
           */
            public void receiveErrorretrieveArtefactBundle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveRelation method
            * override this method for handling normal response from retrieveRelation operation
            */
           public void receiveResultretrieveRelation(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.RetrieveRelationResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveRelation operation
           */
            public void receiveErrorretrieveRelation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for createArtefact method
            * override this method for handling normal response from createArtefact operation
            */
           public void receiveResultcreateArtefact(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.CreateArtefactResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from createArtefact operation
           */
            public void receiveErrorcreateArtefact(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for updateRelation method
            * override this method for handling normal response from updateRelation operation
            */
           public void receiveResultupdateRelation(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.UpdateRelationResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from updateRelation operation
           */
            public void receiveErrorupdateRelation(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for retrieveArtefactHistory method
            * override this method for handling normal response from retrieveArtefactHistory operation
            */
           public void receiveResultretrieveArtefactHistory(
                    eu.compas_ict.www.fragmentservice.FragmentServiceStub.RetrieveArtefactHistoryResponseMessage result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from retrieveArtefactHistory operation
           */
            public void receiveErrorretrieveArtefactHistory(java.lang.Exception e) {
            }
                


    }
    