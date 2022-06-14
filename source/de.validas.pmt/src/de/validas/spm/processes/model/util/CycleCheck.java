/*****************************************************************************************
 * Copyright (c) Validas AG 2010-2019 
 *
 * VALIDAS AG AND ITS AFFILIATES MAKE NO WARRANTY OF ANY KIND 
 * WITH REGARD TO THIS MATERIAL INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. 
 * THIS EXCLUSION OF LIABILITY BUT WILL NOT APPLY TO CLAIMS, 
 * LOSSES, DAMAGES, COSTS (INCLUDING LEGAL COSTS), EXPENSES AND LIABILITIES 
 * CAUSED BY GROSS NEGLIGENCE ("GROBE FAHRLÄSSIGKEIT") OF THE MANAGERIAL 
 * AND SENIOR SUPERVISORY PERSONNEL OF VALIDAS AG AND ITS AFFILIATES, 
 * OR THE WILLFUL MISCONDUCT ("VORSATZ") OF VALIDAS AG AND ITS AFFILIATES. 
 * IT IS ALSO NOT APPLICABLE IN CASE THE GERMAN PRODUCT LIABILITY ACT IS APPLICABLE 
 * OR IN CASE OF INJURY OR DEATH TO PERSONS. 
 * VALIDAS AG AND ITS AFFILIATES SHALL NOT BE LIABLE FOR ANY INCIDENTAL, 
 * INDIRECT, SPECIAL, OR CONSEQUENTIAL DAMAGES WHATSOEVER 
 * (INCLUDING BUT NOT LIMITED TO LOST PROFITS) ARISING OUT OF 
 * OR RELATED TO THIS PUBLICATION OR THE INFORMATION CONTAINED IN IT, 
 * EVEN IF VALIDAS AG AND ITS AFFILIATES HAVE BEEN ADVISED 
 * OF THE POSSIBILITY OF SUCH DAMAGES. 
 * 
 * Contributors:  
 *     Validas AG - Initial API and implementation.
 *****************************************************************************************/
package de.validas.spm.processes.model.util;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.EObjectValidator;

import de.validas.pmt.utils.HierarchyModel;
import metaModel.referenceProcess.Artifact;
import metaModel.referenceProcess.ProcessModule;
import metaModel.referenceProcess.Requirement;

public class CycleCheck extends ProcessesValidationSwitch {

	public static final String DIAGNOSTIC_SOURCE = CycleCheck.class.getSimpleName();
	public static final boolean DIAGNOSTIC_ENABLED = Boolean.TRUE.booleanValue();

	@Override
	public Boolean caseArtifact(Artifact artifact) {
		boolean bResult=true;
		String sMsg="";
		try {
			HierarchyModel.getAllArtifactsWithRecursionCheck(artifact);
		} catch (Exception ex) {
			sMsg=ex.getMessage();
			bResult=false;
		}
		if (!bResult) {
			if (diagnostics != null) {
				int severity = Diagnostic.ERROR;
				String source = DIAGNOSTIC_SOURCE;
				int code = 0;
				String label = EObjectValidator.getObjectLabel(artifact, context);
				String message = label + sMsg;
				Object[] data = new Object[] { artifact };
				Diagnostic diagnostic = new BasicDiagnostic(severity, source, code, message, data);
				diagnostics.add(diagnostic);
			}
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean caseProcessModule(ProcessModule processModule) {
		boolean bResult=true;
		String sMsg="";
		try {
			HierarchyModel.getAllProcessModulesWithRecursionCheck(processModule);
		} catch (Exception ex) {
			sMsg=ex.getMessage();
			bResult=false;
		}
		if (!bResult) {
			if (diagnostics != null) {
				int severity = Diagnostic.ERROR;
				String source = DIAGNOSTIC_SOURCE;
				int code = 0;
				String label = EObjectValidator.getObjectLabel(processModule, context);
				String message = label + sMsg;
				Object[] data = new Object[] { processModule };
				Diagnostic diagnostic = new BasicDiagnostic(severity, source, code, message, data);
				diagnostics.add(diagnostic);
			}
			return false;
		}
		return true;
	}
	
	@Override
	public Boolean caseRequirement(Requirement requirement) {
		boolean bResult=true;
		String sMsg="";
		try {
			HierarchyModel.getAllRequirementsWithRecursionCheck(requirement);
		} catch (Exception ex) {
			sMsg=ex.getMessage();
			bResult=false;
		}
		if (!bResult) {
			if (diagnostics != null) {
				int severity = Diagnostic.ERROR;
				String source = DIAGNOSTIC_SOURCE;
				int code = 0;
				String label = EObjectValidator.getObjectLabel(requirement, context);
				String message = label + sMsg;
				Object[] data = new Object[] { requirement };
				Diagnostic diagnostic = new BasicDiagnostic(severity, source, code, message, data);
				diagnostics.add(diagnostic);
			}
			return false;
		}
		return true;
	}

}
