// 18 Dec 2022: v001

self.addEventListener("install", (event) => {
  event.waitUntil(
    caches.open("v002").then((cache) => {
      return cache.addAll([
        "./",
        "./apple-touch-icon.png",
        "./favicon.ico",
        "./icon-192-maskable.png",
        "./icon-192.png",
        "./icon-512-maskable.png",
        "./icon-512.png",
        "./manifest.json",
        "./index.html",
      ]);
    })
  );
});

self.addEventListener("fetch", (event) => {
  event.respondWith(
    caches.match(event.request).then((response) => {
      if (response) {
        return response;
      } else {
        return fetch(event.request);
      }
    })
  );
});
