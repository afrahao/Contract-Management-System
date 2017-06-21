<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Contract Management System - Operator menu bar</title>
		<link href="css/frame.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="menu">
			<dl>
				<dt>
					Draft
				</dt>
				<dd>
					<a href="toDraft" target="main">Draft Contract</a>
				</dd>
				<dd>
					<a href="toTerminateContract" target="main">Termination  Contract</a>
				</dd>
				</dl>
				<dl>
				<dt>
					Finalize
				</dt>
				<dd>
					<a href="finalizeContractList" target="main">Contract to be finalized</a>
				</dd>
				<dd>
					<a href="finalizedContract" target="main">Finalized Contract</a>
				</dd>
				<dd>
					<a href="toQProcess" target="main">Query Process</a>
				</dd>
			</dl>
			<dl>
				<dt>
					Countersign
				</dt>
				<dd>
					<a href="countersignContractList" target="main">Contract to be countersigned</a>
				</dd>
				<dd>
					<a href="countersignedContract" target="main">Countersigned Contract</a>
				</dd>
			</dl>
			<dl>
				<dt>
					Approve
				</dt>
				<dd>
					<a href="approveContractList" target="main">Contract to be approved</a>
				</dd>
				<dd>
					<a href="approvedContract" target="main">Approved Contract</a>
				</dd>
			</dl>
			<dl>
				<dt>
					Assign
				</dt>
				<dd>
					<a href="assignContractList" target="main">Contract to be Assigned</a>
				</dd>
				<dd>
					<a href="assignedContract" target="main">Assigned Contract</a>
				</dd>
			</dl>
			<dl>
				<dt>
					Sign
				</dt>
				<dd>
					<a href="signContractList" target="main">Contract to be signed</a>
				</dd>
				<dd>
					<a href="signedContract" target="main">Signed Contract</a>
				</dd>
			</dl>
		</div>
	</body>
</html>
