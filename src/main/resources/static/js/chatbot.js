document.addEventListener("DOMContentLoaded", function() {
    (function(d, t) {
        var v = d.createElement(t), s = d.getElementsByTagName(t)[0];
        v.onload = function() {
          window.voiceflow.chat.load({
            verify: { projectID: '66457b18c00a4f93f1e8773b' },
            url: 'https://general-runtime.voiceflow.com',
            versionID: 'production'
          });
        };
        v.src = "https://cdn.voiceflow.com/widget/bundle.mjs"; 
        v.type = "text/javascript"; 
        s.parentNode.insertBefore(v, s);
    })(document, 'script');
  });
  