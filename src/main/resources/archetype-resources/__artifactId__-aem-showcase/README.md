#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

#${artifactTitle} Component Showcase
=================================

This project deploys a Static Showcase site that is used to demonstrate components to end users. And is used for Automation Testting


Content Cleaning
=======

Please clean your content when checking it into codebase, use Regex search and replace in the IDE to replace all mathing lines with empty stirg.

You will need to do this couple of time. At very least please remove Account and Unique ID info. 


# Replace all identifier attributes these with ""

```
^.+(cq|jcr)\:(createdBy|lastReplicatedBy|lastModifiedBy|lastReplicated|lastReplicationAction|uuid)\=\".+\"\n
^.+(cq|jcr)\:(createdBy|lastReplicatedBy|lastModifiedBy|lastReplicated|lastReplicationAction|uuid)\=\".+\"\>
```

# Remove all system generated attributes

```
^.+(cq|jcr)\:(created|lastReplicated|lastModified|lastReplicationAction|uuid)\=\".+\"\n
^.+(cq|jcr)\:(created|lastReplicated|lastModified|lastReplicationAction|uuid)\=\".+\"\>
```

# Remove all `componentId` instances

```
DO NOT REMOVE COMPONENT ID's
```

# Showcase Template

For consistency of testing and validation each page in showcase should be similar to others. Existing test template are tailored to match template structure described in this section.

What your showcase page should contain:

* a ```layout/article``` container for page contents
    * a ```details/page-details``` component with info about showcase page
    * a ```layout/contentblockmenu``` to show all component variants in showcase
    * a ```layout/contentblock``` with info about  variant with a sequential name to ensure news variants cant be added easily


Please use following as a template for Component showcase page.

WARNING: Please DO NOT commit auto generated content, only commit what you expect to be there for testing.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<jcr:root xmlns:sling="http://sling.apache.org/jcr/sling/1.0" xmlns:cq="http://www.day.com/jcr/cq/1.0" xmlns:jcr="http://www.jcp.org/jcr/1.0" xmlns:nt="http://www.jcp.org/jcr/nt/1.0"
          jcr:primaryType="cq:Page">
    <jcr:content
            cq:tags="[${contentFolderName}:content-type/page]"
            cq:template="/conf/${confFolderName}/settings/wcm/templates/twocolumn"
            jcr:primaryType="cq:PageContent"
            jcr:title="Nav List"
            sling:resourceType="${appsFolderName}/components/template/base">
        <article
                jcr:primaryType="nt:unstructured"
                sling:resourceType="${appsFolderName}/components/layout/article">
            <par
                    jcr:primaryType="nt:unstructured"
                    sling:resourceType="${appsFolderName}/components/layout/container">
                <page-details
                        jcr:primaryType="nt:unstructured"
                        sling:resourceType="${appsFolderName}/components/details/page-details"/>
                <contentblockmenu1
                        jcr:primaryType="nt:unstructured"
                        sling:resourceType="${appsFolderName}/components/layout/contentblockmenu"
                        componentId="contentblockmenu1"/>
                <contentblock1
                        jcr:primaryType="nt:unstructured"
                        sling:resourceType="${appsFolderName}/components/layout/contentblock"
                        componentId="contentblock1"
                        hideTitle="false"
                        hideTitleSeparator="true"
                        title="Default Fixed List"
                        variant="advsection">
                    <par
                            jcr:primaryType="nt:unstructured"
                            sling:resourceType="${appsFolderName}/components/layout/container">

                        <!-- YOUR COMPONENT GOES HERE -->

                    </par>
                </contentblock1>

            </par>
        </article>
    </jcr:content>
</jcr:root>

```
