# crawl_simulate.py
# this was written to solve the "Browsercheck" challenge

# By Aleksey
#  - github.com/Alekseyyy
#  - medium.com/@EpsilonCalculus

# this is what I'm ripping off...
# - https://stackoverflow.com/questions/24226781/changing-user-agent-in-python-3-for-urrlib-request-urlopen
# - https://ourcodeworld.com/articles/read/812/how-to-create-an-html-file-viewer-with-wxpython
 
import wx
from wx import html
 
from urllib import request
 
class MyHTMLFrame(wx.Frame):
	def __init__(self, parent, title, haxedpage):
		wx.Frame.__init__(
			self,
			parent,
			-1,
			title,
			size = (600, 400)
		)
 
		thisHtml = html.HtmlWindow(self)
 
		if "gtk2" in wx.PlatformInfo:
			html.SetStandardFonts()
 
		thisHtml.SetPage(haxedpage)
 
my_request = request.Request(
	url="http://timesink.be/browsercheck/",
	data = None,
	headers = {
		"User-Agent": "Mozilla/5.0 (compatible; Ask Jeeves/Teoma; +http://about.ask.com/en/docs/about/webmasters.shtml)"
	}
)
 
page = request.urlopen(my_request)
page = page.read().decode()
 
renderer = wx.App()
renderedPage = MyHTMLFrame(None, "EntropyThot Rulz :D", page)
renderedPage.Show()
renderer.MainLoop()
